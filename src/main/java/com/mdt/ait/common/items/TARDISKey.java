package com.mdt.ait.common.items;

import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.enums.EnumLockState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.mdt.ait.core.init.enums.EnumDoorState.BOTH;
import static com.mdt.ait.core.init.enums.EnumDoorState.FIRST;

public class TARDISKey extends Item {

    public TARDISKey(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    /*public EnumLockState currentlockstate = EnumLockState.UNLOCKED;
    public EnumLockState previouslockstate = EnumLockState.UNLOCKED;

    public EnumLockState getNextLockState() {
        switch (currentlockstate) {
            case UNLOCKED:
                return EnumLockState.LOCKED;
            case LOCKED:
                return EnumLockState.UNLOCKED;
        }
        return EnumLockState.UNLOCKED;
    }

    public EnumLockState currentLockState() {
        return currentlockstate;
    }

    public void setLockState(EnumLockState currentlockstate) {
        this.currentlockstate = currentlockstate;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = playerentity.level;
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof TardisBlock && playerentity.isCrouching() && currentlockstate == EnumLockState.LOCKED) {
            TileEntity tileEntity = world.getBlockEntity(blockpos);
            if (tileEntity instanceof TardisTileEntity) {
                ((TardisTileEntity) tileEntity).lockTardis(context, blockpos, blockstate, block);
                if(currentlockstate != previouslockstate) {
                    currentlockstate = EnumLockState.UNLOCKED;
                }
            }
        }
        if (block instanceof TardisBlock && playerentity.isCrouching() && currentlockstate == EnumLockState.UNLOCKED) {
            TileEntity tileEntity = world.getBlockEntity(blockpos);
            if (tileEntity instanceof TardisTileEntity) {
                ((TardisTileEntity) tileEntity).unlockTardis(context, blockpos, blockstate, block);
                if(currentlockstate != previouslockstate) {
                    currentlockstate = EnumLockState.LOCKED;
                }
            }
        }

        return ActionResultType.sidedSuccess(world.isClientSide());
    }*/
}
