package com.mdt.ait.common.tileentities;

import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumEggTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArsEggTile extends TileEntity implements ITickableTileEntity {

    public EnumEggTypes eggExisting = EnumEggTypes.ACTIVE;

    public ArsEggTile() {
        super(AITTiles.ARS_EGG_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
    }

    public EnumEggTypes getNextEgg() {
        switch(eggExisting) {
            case ACTIVE:
                return EnumEggTypes.DEACTIVE;
            case DEACTIVE:
                return EnumEggTypes.ACTIVE;
            default:
                return EnumEggTypes.ACTIVE;
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    public ActionResultType useOn(World pLevel, PlayerEntity pPlayer, BlockPos pPos, Hand pHand) {
        if(pPlayer.getMainHandItem().isEmpty() && this.eggExisting == EnumEggTypes.ACTIVE && pPlayer.isCrouching()) {
            pPlayer.setItemInHand(Hand.MAIN_HAND, new ItemStack(AITItems.ARS_EGG.get()));
            pLevel.playSound(null, worldPosition, SoundEvents.BEACON_DEACTIVATE, SoundCategory.MASTER, 7, 1);
            this.eggExisting = getNextEgg();
            return ActionResultType.SUCCESS;
        }
        if (pPlayer.getMainHandItem().getItem() == AITItems.ARS_EGG.get() && this.eggExisting == EnumEggTypes.DEACTIVE && !pPlayer.isCrouching()) {
            pPlayer.setItemInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
            pLevel.playSound(null, worldPosition, SoundEvents.BEACON_ACTIVATE, SoundCategory.MASTER, 7, 1);
            this.eggExisting = getNextEgg();
            return ActionResultType.SUCCESS;
        }
        System.out.println(eggExisting + "  " + pPlayer.getMainHandItem());
        return ActionResultType.FAIL;
    }

    @Override
    public void load(BlockState blockState, CompoundNBT compoundNBT) {
        this.eggExisting = EnumEggTypes.values()[compoundNBT.getInt("eggExisting")];
        super.load(blockState, compoundNBT);
    }

    @Override
    public CompoundNBT save(CompoundNBT pCompound) {
        pCompound.putInt("eggExisting", this.eggExisting.ordinal());
        return super.save(pCompound);
    }
}
