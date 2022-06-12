package com.mdt.ait.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
//This cannot implement INeedItem because it is being used as the icon for an item group. When being registered, the block has not initialised yet so the item group icon will become null


public class TransparentGrateBlock extends Block {

    public TransparentGrateBlock(Properties prop, SoundType sound, float hardness, float resistance) {

        super(prop.sound(sound).noCollission().strength(hardness, resistance).isSuffocating((state, iBlockReader, pos) -> false));
    }

    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0;
    }


}
