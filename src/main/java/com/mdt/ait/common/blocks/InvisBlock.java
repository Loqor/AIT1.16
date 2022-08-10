package com.mdt.ait.common.blocks;

import net.minecraft.block.BarrierBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;

public class InvisBlock extends BarrierBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public InvisBlock() {
        super(Properties.of(Material.HEAVY_METAL).strength(15.0f).noOcclusion().instabreak());
    }
}
