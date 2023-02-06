package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.*;
import com.mdt.ait.core.init.enums.EnumDoorState;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.UUID;

public class DoorSwitchControlTile extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;
    public DoorSwitchStates leverState = DoorSwitchStates.FIRST;
    public float firstLeverPosition = 0.0f;
    public float secondLeverPosition = 0.0f;

    public DoorSwitchControlTile() {
        super(AITTiles.DOOR_SWITCH_CONTROL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        if (leverState == DoorSwitchStates.FIRST) {
            if (firstLeverPosition > 0f) {
                firstLeverPosition -= 15.0f;
            } else {
                firstLeverPosition = 0f;
            }
            if (secondLeverPosition > 0f) {
                secondLeverPosition -= 15.0f;
            } else {
                secondLeverPosition = 0f;
            }
        }
        if(leverState == DoorSwitchStates.SECOND) {
            if (firstLeverPosition < 30f) {
                firstLeverPosition += 5.0f;
            } else {
                firstLeverPosition = 30f;
            }
            if (secondLeverPosition < 30f) {
                secondLeverPosition += 5.0f;
            } else {
                secondLeverPosition = 30f;
            }
        }
    }

    public DoorSwitchStates getNextLeverState() {
        switch (leverState) {
            case FIRST:
                return DoorSwitchStates.SECOND;
            case SECOND:
                return DoorSwitchStates.FIRST;
        }
        return DoorSwitchStates.FIRST;
    }

    public DoorSwitchStates getLastLeverState() {
        switch (leverState) {
            case FIRST:
                return DoorSwitchStates.SECOND;
            case SECOND:
                return DoorSwitchStates.FIRST;
        }
        return DoorSwitchStates.FIRST;
    }

    public DoorSwitchStates getLeverState() {
        return leverState;
    }

    public void setLeverState(DoorSwitchStates state) {
        leverState = state;
    }

    public void setNextDoorState() {
        if (this.tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    /*Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                    if(tardis.interiorDoorPosition != null) {
                        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) level.getBlockEntity(tardis.interiorDoorPosition);
                        TardisTileEntity tardisTileEntity = (TardisTileEntity) AIT.server.getLevel(tardis.exterior_dimension).getBlockEntity(tardis.exteriorPosition);
                        if (tardisTileEntity != null) {
                            assert basicInteriorDoorTile != null;
                            tardisTileEntity.setDoorState(basicInteriorDoorTile.currentstate);
                            tardisTileEntity.syncToClient();
                            syncToClient();
                            if (basicInteriorDoorTile != null) {
                                if (leverState == DoorSwitchStates.FIRST) {
                                    level.playSound(null, worldPosition, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.MASTER, 7, 1);
                                    basicInteriorDoorTile.setDoorState(EnumDoorState.CLOSED);
                                } else {
                                    level.playSound(null, worldPosition, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.MASTER, 7, 1);
                                    basicInteriorDoorTile.setDoorState(EnumDoorState.BOTH);
                                }
                                basicInteriorDoorTile.syncToClient();
                                syncToClient();
                            }
                        }
                    }
                    syncToClient();*/
                }
            }
        }
    }

    public void toggleDoorsLocked() {
        if (this.tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    /*Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                    if(tardis.interiorDoorPosition != null) {
                        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) level.getBlockEntity(tardis.interiorDoorPosition);
                        TardisTileEntity tardisTileEntity = (TardisTileEntity) AIT.server.getLevel(tardis.exterior_dimension).getBlockEntity(tardis.exteriorPosition);
                        if(basicInteriorDoorTile != null) {
                            if (basicInteriorDoorTile.lockedState) {
                                leverState = DoorSwitchStates.FIRST;
                                basicInteriorDoorTile.setLockedState(false, EnumDoorState.CLOSED);
                            } else {
                                leverState = DoorSwitchStates.FIRST;
                                basicInteriorDoorTile.setLockedState(true, EnumDoorState.CLOSED);
                            }
                            if (tardisTileEntity != null) {
                                if (tardisTileEntity.lockedState) {
                                    tardisTileEntity.setLockedState(false, basicInteriorDoorTile.currentstate);
                                } else {
                                    tardisTileEntity.setLockedState(true, basicInteriorDoorTile.currentstate);
                                }
                            }
                        }
                    }*/
                }
            }
        }
    }

    public ActionResultType useOn(World world, PlayerEntity pPlayer, BlockPos pPos, Hand pHandIn, BlockRayTraceResult pHit) {
        BlockState blockstate = world.getBlockState(pPos);
        if(pHandIn == Hand.MAIN_HAND) {
            if (pPlayer.isCrouching()) {
                toggleDoorsLocked();
                leverState = getNextLeverState();
                syncToClient();
                level.playSound(null, worldPosition, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
            } else {
                setNextDoorState();
                leverState = getNextLeverState();
                syncToClient();
            }
        }
        syncToClient();
        //System.out.println(getLeverState());
        return ActionResultType.SUCCESS;
    }

    public void onPlace() {
        if(this.tardisID != null) {
            if (this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    //Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                    syncToClient();
                }
            }
        }
        leverState = DoorSwitchStates.FIRST;
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
        this.leverState = DoorSwitchStates.values()[nbt.getInt("leverState")];
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        if (this.tardisID != null) {
            nbt.putUUID("tardisID", this.tardisID);
        }
        nbt.putInt("leverState", this.leverState.ordinal());
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
