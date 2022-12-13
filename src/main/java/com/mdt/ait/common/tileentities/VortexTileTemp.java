package com.mdt.ait.common.tileentities;

import com.mdt.ait.core.init.AITTiles;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class VortexTileTemp extends TileEntity implements ITickableTileEntity {

    public float spinning;

    public VortexTileTemp() {
        super(AITTiles.VORTEX_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        ++spinning;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }
}
