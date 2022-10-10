package com.mdt.ait.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.world.server.ServerWorld;

public class FallingTardisEntity extends FallingBlockEntity {
    public FallingTardisEntity(ServerWorld pLevel, double v, double y, double v1, BlockState blockState) {
        super(pLevel, v, y, v1, blockState);
    }
    //@TODO: Make this the commented out stuff in the falling block
}
