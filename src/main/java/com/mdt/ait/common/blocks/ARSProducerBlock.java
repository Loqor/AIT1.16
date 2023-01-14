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
            if (checkHeldItem(pPlayer, Items.LIGHT_BLUE_DYE)) {
                Random random = new Random();
                freeBelow = random.nextInt(5);
                freeBelow++;
                placeBelowBlocks(pPos,pLevel,freeBelow,Blocks.CHAIN,Blocks.SOUL_LANTERN);
            }
            if (checkHeldItem(pPlayer, Items.ORANGE_DYE)) { // check what player is holding
                Random random = new Random();
                freeBelow = random.nextInt(5);
                freeBelow++;
                placeBelowBlocks(pPos,pLevel,freeBelow,Blocks.CHAIN,Blocks.LANTERN);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    // @TODO TIMER FOR ARS PRODUCER
//    @Override
//    public void tick(BlockState pState, ServerWorld pLevel, BlockPos pPos, Random pRand) {
//        if (isGrowing == true) {
//            runPlaceFunction();
//        }
//        super.tick(pState, pLevel, pPos, pRand);
//    }


    private boolean placeBelowBlocks(BlockPos blockPos, World world, int checkLimit, Block fillerBlock, Block bottomBlock) {
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
                world.setBlock(blockPos.below(i), bottomBlock.defaultBlockState(), Constants.BlockFlags.DEFAULT);
            }
            else {
                world.setBlock(blockPos.below(i), fillerBlock.defaultBlockState(), Constants.BlockFlags.DEFAULT);
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
