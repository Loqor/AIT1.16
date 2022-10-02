package com.mdt.ait.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

public class GallifreySandBlock extends Block {

    public GallifreySandBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        Block plant = plantable.getPlant(world, pos.relative(facing)).getBlock();

        if (plant == Blocks.DEAD_BUSH){
            return true;
        } else {
            return super.canSustainPlant(state, world, pos, facing, plantable);
        }
    }
}
