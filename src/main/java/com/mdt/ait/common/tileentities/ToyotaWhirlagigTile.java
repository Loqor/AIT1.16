package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumRotorState;
import io.mdt.ait.tardis.TARDIS;
import io.mdt.ait.tardis.TARDISManager;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.UUID;

public class ToyotaWhirlagigTile extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;
    public float rotorTick;
    public float setRotorTick = 0;
    private int __dontUse = 0;
    public boolean isLoaded = false;
    public boolean isInFlight;
    public EnumRotorState currentstate = EnumRotorState.STATIC;
    public float spinny = 0;
    public boolean atCurrentCoordinates;
    public boolean uselessThing;
    public float thing;

    public EnumRotorState currentState() {
        return this.currentstate;
    }

    public ToyotaWhirlagigTile() {
        super(AITTiles.TOYOTA_WHIRLAGIG_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        ++thing;
        if(this.tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    TARDIS tardis = TARDISManager.findTARDIS(this.tardisID);
                    ServerWorld ExteriorWorld = AIT.server.getLevel(tardis.getDimension());
                    if (!atCurrentCoordinates) {
                        addToRotorSpin(thing);
                        if(ExteriorWorld.getBlockEntity(tardis.getPosition()) != null) {
                            addToRotorSpin(spinny);
                        }
                    }
                    if(ExteriorWorld.getBlockEntity(tardis.getPosition()) == null) {
                        atCurrentCoordinates = false;
                    }
                }
            }
        }
    }

    public void addToRotorSpin(float number) {
        spinny = number;
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
        this.currentstate = EnumRotorState.values()[nbt.getInt("currentstate")];
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        if (this.tardisID != null) {
            nbt.putUUID("tardisID", this.tardisID);
        }
        nbt.putInt("currentstate", this.currentstate.ordinal());
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
