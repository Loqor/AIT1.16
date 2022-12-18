package com.mdt.ait.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RickPortalBlock extends Block {
    public RickPortalBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    public RickPortalBlock() {
        super(Properties.of(Material.PORTAL).strength(-1.0f).noOcclusion().lightLevel((p_235464_0_) -> 5).noCollission());
    }
    @Override
    public void entityInside(BlockState pState, World pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
        pEntity.moveTo(new BlockPos(pPos.getX() + 10, pPos.getY() + 10, pPos.getZ()), pEntity.getYHeadRot(), 0);
    }
}
