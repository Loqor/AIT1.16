package com.mdt.ait.common.tileentities;

import com.mdt.ait.core.init.AITTiles;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class TypewriterTile extends TileEntity implements ITickableTileEntity {

    public TypewriterTile() {
        super(AITTiles.TYPEWRITER_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }
}
