package com.mdt.ait.common.items;

import com.mdt.ait.common.blocks.TestBlock;
import com.mdt.ait.tardis.TardisInteriors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class DevTool extends Item {
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

        if (block instanceof TestBlock && playerentity.isCrouching()) { // Creates interior
            if (!world.isClientSide) {
                System.out.println("Creating exterior");
                ServerWorld serverWorld = (ServerWorld) world;
                BlockPos interiorCenterPos = TardisInteriors.devInterior.getCenterPosition();
                BlockPos generateFromPos = new BlockPos(blockpos.getX() - interiorCenterPos.getX(), blockpos.getY() - interiorCenterPos.getY(), blockpos.getZ()-interiorCenterPos.getZ());
                TardisInteriors.devInterior.placeInterior(serverWorld, generateFromPos);

            }

        }
        return ActionResultType.SUCCESS;
    }


}
