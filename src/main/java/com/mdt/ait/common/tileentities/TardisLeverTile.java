package com.mdt.ait.common.tileentities;

import com.mdt.ait.core.init.AITTiles;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class TardisLeverTile extends TileEntity implements ITickableTileEntity {

    public TardisLeverTile() {
        super(AITTiles.TARDIS_LEVER_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }
}
