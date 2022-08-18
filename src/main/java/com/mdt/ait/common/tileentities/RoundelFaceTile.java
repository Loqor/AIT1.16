package com.mdt.ait.common.tileentities;

import com.mdt.ait.common.blocks.RoundelFaceBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumCoralState;
import com.mdt.ait.core.init.enums.EnumRoundelFaceState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class RoundelFaceTile extends TileEntity {

    public EnumRoundelFaceState roundelFaceState = EnumRoundelFaceState.FULL_MINT;

    public RoundelFaceTile() {
        super(AITTiles.ROUNDEL_FACE_TILE_ENTITY_TYPE.get());
    }

    public EnumRoundelFaceState getNextRoundelFaceState() {
        switch (roundelFaceState) {
            case FULL_MINT:
                return EnumRoundelFaceState.HALF_MINT;
            case HALF_MINT:
                return EnumRoundelFaceState.FULL_MINT;
        }
        return EnumRoundelFaceState.FULL_MINT;
    }

    public EnumRoundelFaceState getRoundelFaceState() {
        return this.roundelFaceState;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    public void useOnRoundelFace(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        Item item = playerentity.getMainHandItem().getItem();

        if (block instanceof RoundelFaceBlock && item == AITItems.TENNANT_SONIC.get()) {
            roundelFaceState = getNextRoundelFaceState();
        }
    }
}
