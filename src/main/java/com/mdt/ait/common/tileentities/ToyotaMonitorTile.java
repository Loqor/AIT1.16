package com.mdt.ait.common.tileentities;

import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.tardis.special.DematTransit;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nonnull;
import java.util.UUID;

public class ToyotaMonitorTile extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;
    public String flightTimeRemaining = "0%";
    public DematTransit dematTransit;
    public int flightTicks = 0;

    public ToyotaMonitorTile() {
        super(AITTiles.TOYOTA_MONITOR_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        if (this.dematTransit != null) {
            if (this.dematTransit.readyForDemat) {
                this.flightTimeRemaining = (" " + (flightTicks * 100) / this.dematTransit.getFlightTicks() + "%");
                if (flightTicks == this.dematTransit.getFlightTicks()) {
                    flightTicks = 0;
                }
                if (flightTicks < this.dematTransit.getFlightTicks()) {
                    flightTicks += 1;
                }
            }
            if (this.dematTransit != null) {
                if (flightTicks >= this.dematTransit.getFlightTicks()) {
                    flightTicks = 0;
                    syncToClient();
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        if (nbt.contains("tardisID")) {
            this.tardisID = nbt.getUUID("tardisID");
        }
        this.flightTimeRemaining = nbt.getString("flightTime");
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        if (this.tardisID != null) {
            nbt.putUUID("tardisID", this.tardisID);
        }
        nbt.putString("flightTime", this.flightTimeRemaining);
        return super.save(nbt);
    }

    @Override
    @Nonnull
    public CompoundNBT getUpdateTag() {
        return save(new CompoundNBT());
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(worldPosition, 0, save(new CompoundNBT()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        load(getBlockState(), packet.getTag());
    }

    public void syncToClient() {
        assert level != null;
        level.setBlocksDirty(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition));
        level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        setChanged();
    }
}
