package com.mdt.ait.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

public class ARSProducerBlock extends Block {
    private int freeBelow;

    public ARSProducerBlock(Properties properties) {
        super(properties);
    }


    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        if (!pLevel.isClientSide()) {
            if (checkHeldItem(pPlayer, Items.BONE_MEAL)) { // check if holding bone meal
                Random random = new Random();
                freeBelow = random.nextInt(5);
                freeBelow++;
                placeBelowBlocks(pPos,pLevel,freeBelow);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }


    private boolean placeBelowBlocks(BlockPos blockPos, World world, int checkLimit) {
        int safeBlocks = 0;
        for (int i = 1;i <= checkLimit; i++) {
            if (world.getBlockState(blockPos.below(i)).getBlock() == Blocks.AIR) {
                safeBlocks++;
            }
        }
        if (safeBlocks != checkLimit) {
            return false;
        }

        for (int i = 1;i <= checkLimit;i++) {
            if (i == checkLimit) {
                world.setBlock(blockPos.below(i), Blocks.SOUL_LANTERN.defaultBlockState(), Constants.BlockFlags.DEFAULT);
            }
            else {
                world.setBlock(blockPos.below(i), Blocks.CHAIN.defaultBlockState(), Constants.BlockFlags.DEFAULT);
            }
        }
        return true;
    }

    private boolean checkHeldItem(PlayerEntity player, Item item) {
        if (player.getMainHandItem().getItem() == item) {
            return true;
        }
        return false;
    }
}
