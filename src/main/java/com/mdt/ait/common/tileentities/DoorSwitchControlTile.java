package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.ExteriorFacingControlBlock;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumInteriorDoorType;
import com.mdt.ait.core.init.enums.EnumLeverState;
import com.mdt.ait.tardis.Tardis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.UUID;

public class DoorSwitchControlTile extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;
    public EnumLeverState leverState = EnumLeverState.DEACTIVE;
    public float firstLeverPosition = 0.0f;
    public float secondLeverPosition = 0.0f;

    public DoorSwitchControlTile() {
        super(AITTiles.DOOR_SWITCH_CONTROL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        if (leverState == EnumLeverState.DEACTIVE) {
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
        if(leverState == EnumLeverState.ACTIVE) {
            if (firstLeverPosition < 30f) {
                secondLeverPosition += 5.0f;
            } else {
                secondLeverPosition = 30f;
            }
        }
        if(leverState == EnumLeverState.DOOR_SWITCH) {
            if (firstLeverPosition < 30f) {
                firstLeverPosition += 5.0f;
            } else {
                firstLeverPosition = 30f;
            }
        }
    }

    public EnumLeverState getNextLeverState() {
        switch (leverState) {
            case DEACTIVE:
                return EnumLeverState.DOOR_SWITCH;
            case DOOR_SWITCH:
                return EnumLeverState.ACTIVE;
            case ACTIVE:
                return EnumLeverState.DEACTIVE;
        }
        return EnumLeverState.DEACTIVE;
    }

    public EnumLeverState getLeverState() {
        return this.leverState;
    }

    public void setLeverState(EnumLeverState state) {
        this.leverState = state;
    }

    public void setNextDoorState() {
        if (this.tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                    if(tardis.interior_door_position != null) {
                        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) level.getBlockEntity(tardis.interior_door_position);
                        TardisTileEntity tardisTileEntity = (TardisTileEntity) AIT.server.getLevel(tardis.exterior_dimension).getBlockEntity(tardis.exterior_position);
                        if(tardisTileEntity != null) {
                            if(this.leverState == EnumLeverState.DEACTIVE) {
                                tardisTileEntity.currentstate = EnumDoorState.CLOSED;
                                syncToClient();
                            }
                            if(this.leverState == EnumLeverState.DOOR_SWITCH) {
                                tardisTileEntity.currentstate = EnumDoorState.FIRST;
                                syncToClient();
                            }
                            if(this.leverState == EnumLeverState.ACTIVE) {
                                tardisTileEntity.currentstate = EnumDoorState.BOTH;
                                syncToClient();
                            }
                        }
                        if(basicInteriorDoorTile != null) {
                            if(this.leverState == EnumLeverState.DEACTIVE) {
                                basicInteriorDoorTile.currentstate = EnumDoorState.CLOSED;
                                syncToClient();
                            }
                            if(this.leverState == EnumLeverState.DOOR_SWITCH) {
                                basicInteriorDoorTile.currentstate = EnumDoorState.FIRST;
                                syncToClient();
                            }
                            if(this.leverState == EnumLeverState.ACTIVE) {
                                basicInteriorDoorTile.currentstate = EnumDoorState.BOTH;
                                syncToClient();
                            }
                        }
                    }
                    syncToClient();
                }
            }
        }
    }

    public void toggleDoorsLocked() {
        if (this.tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                    if(tardis.interior_door_position != null) {
                        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) level.getBlockEntity(tardis.interior_door_position);
                        TardisTileEntity tardisTileEntity = (TardisTileEntity) AIT.server.getLevel(tardis.exterior_dimension).getBlockEntity(tardis.exterior_position);
                        if(basicInteriorDoorTile != null) {
                            if(basicInteriorDoorTile.lockedState) {
                                this.leverState = EnumLeverState.DEACTIVE;
                                basicInteriorDoorTile.setLockedState(false, EnumDoorState.CLOSED);
                            } else {
                                this.leverState = EnumLeverState.DEACTIVE;
                                basicInteriorDoorTile.setLockedState(true, EnumDoorState.CLOSED);
                            }
                        }
                        if(tardisTileEntity != null) {
                            if(tardisTileEntity.lockedState) {
                                tardisTileEntity.setLockedState(false, EnumDoorState.CLOSED);
                            } else {
                                tardisTileEntity.setLockedState(true, EnumDoorState.CLOSED);
                            }
                        }
                    }
                }
            }
        }
    }

    public ActionResultType useOn(World world, PlayerEntity pPlayer, BlockPos pPos, Hand pHandIn, BlockRayTraceResult pHit) {
        BlockState blockstate = world.getBlockState(pPos);
        Block block = blockstate.getBlock();
        if(pHandIn == Hand.MAIN_HAND) {
            if (pPlayer.isCrouching()) {
                toggleDoorsLocked();
                syncToClient();
            } else {
                setNextDoorState();
                syncToClient();
            }
        }
        setLeverState(this.getNextLeverState());
        syncToClient();
        System.out.println(getLeverState());
        return ActionResultType.SUCCESS;
    }

    public void onPlace() {
        if(this.tardisID != null) {
            if (this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    Tardis tardis = AIT.tardisManager.getTardis(tardisID);
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
        this.leverState = EnumLeverState.values()[nbt.getInt("leverState")];
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
