package com.mdt.ait.common.items;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TestBlock;
import com.mdt.ait.core.init.enums.EnumDevToolModes;
import com.mdt.ait.tardis.TardisInteriors;
import com.mdt.ait.tardis.TardisManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nullable;
import java.util.UUID;

public class DevTool extends Item {

    public EnumDevToolModes current_mode;

    private boolean isDirty = false;

    public DevTool(Properties p_i48487_1_) {
        super(p_i48487_1_.stacksTo(1).fireResistant());
    }

    @Override
    public void onUseTick(World pWorldIn, LivingEntity pLivingEntityIn, ItemStack pStack, int pCount) {

    }

    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        assert playerentity != null;
        World world = playerentity.level;
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        Item item = playerentity.getMainHandItem().getItem();
        if (!world.isClientSide) {
            playerentity.setItemInHand(context.getHand(), handleItemStackNBT(playerentity.getItemInHand(context.getHand())));
            if (block instanceof TestBlock && playerentity.isCrouching() && this.current_mode.equals(EnumDevToolModes.PLACE_EXTERIOR)) { // Creates interior
//                System.out.println("Creating exterior");
//                ServerWorld serverWorld = (ServerWorld) world;
//                BlockPos interiorCenterPos = TardisInteriors.devInterior.getCenterPosition();
//                BlockPos generateFromPos = new BlockPos(blockpos.getX() - interiorCenterPos.getX(), blockpos.getY() - interiorCenterPos.getY(), blockpos.getZ()-interiorCenterPos.getZ());
//                TardisInteriors.devInterior.placeInterior(serverWorld, generateFromPos);

                System.out.println(AIT.tardisManager.getTardisFromPosition(playerentity.blockPosition()).tardisID);

            }
        }

        return ActionResultType.SUCCESS;
    }

    private CompoundNBT saveNBT(CompoundNBT tag) {
        tag.putString("mode", this.current_mode.toString());
        return tag;
    }

    private void loadNBT(CompoundNBT tag) {

        if (tag.getString("mode").equals("")) {
            System.out.println("Current Mode Set to null");
            this.current_mode = null;
        } else {
            this.current_mode = EnumDevToolModes.valueOf(tag.getString("mode"));
        }

    }

    public ItemStack handleItemStackNBT(ItemStack itemStack) {
        CompoundNBT tag = itemStack.getOrCreateTag();


        this.loadNBT(tag);
        if (this.current_mode == null) {
            this.current_mode = EnumDevToolModes.PLACE_EXTERIOR;
            saveNBT(tag);
            itemStack.setTag(tag);
        } else if (isDirty) {
            saveNBT(tag);
            itemStack.setTag(tag);
        }
        return itemStack;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (playerEntity instanceof  ServerPlayerEntity) {
            ItemStack usedItem = playerEntity.getItemInHand(hand);
            playerEntity.setItemInHand(hand, handleItemStackNBT(usedItem));
        }
        return super.use(world, playerEntity, hand);
    }


}
