package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisLeverBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.*;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.TardisManager;
import com.mdt.ait.tardis.special.DematTransit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.UUID;

import static com.mdt.ait.core.init.enums.EnumDoorState.CLOSED;

public class TardisLeverTile extends TileEntity implements ITickableTileEntity {

    public EnumLeverState leverState = EnumLeverState.DEACTIVE;
    public float leverPosition = 0;
    public int runafter = 0;
    public UUID tardisID;
    public boolean canPull = true;

    public DematTransit dematTransit;
    public int flightTicks = 0;
    public boolean doorIsClosed = false;

    public TardisLeverTile() {
        super(AITTiles.TARDIS_LEVER_TILE_ENTITY_TYPE.get());
    }

    public EnumLeverState getNextLeverState() {
        switch (leverState) {
            case DEACTIVE:
                return EnumLeverState.ACTIVE;
            case ACTIVE:
                return EnumLeverState.DEACTIVE;
        }
        return EnumLeverState.DEACTIVE;
    }

    public EnumLeverState getPreviousLeverState() {
        switch (leverState) {
            case ACTIVE:
                return EnumLeverState.DEACTIVE;
            case DEACTIVE:
                return EnumLeverState.ACTIVE;
        }
        return EnumLeverState.ACTIVE;
    }

    public EnumLeverState getLeverState() {
        return this.leverState;
    }

    public void setLeverState(EnumLeverState state) {
        this.leverState = state;
    }

    public void changeMatStateFromLever() {
        if(tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                    ServerWorld world = AIT.server.getLevel(tardis.exterior_dimension);
                    ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                    assert world != null;
                    assert tardisWorld != null;
                    if (leverState == EnumLeverState.ACTIVE) {
                        if (AIT.tardisManager.doesTardisHaveATargetLocation(tardisID)) {
                            tardisWorld.playSound(null, tardis.center_position, AITSounds.TARDIS_TAKEOFF.get(), SoundCategory.MASTER, 7, 1);
                            this.dematTransit = AIT.tardisManager.moveTardisToTargetLocation(tardisID);
                            if (this.dematTransit.leverPos != this.worldPosition) {
                                this.dematTransit.leverPos = getBlockPos();
                            }
                        } else {
                            leverState = EnumLeverState.DEACTIVE;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void tick() {
        if (leverState == EnumLeverState.DEACTIVE) {
            if (leverPosition > 0f) {
                leverPosition -= 15.0f;
            } else {
                leverPosition = 0f;
            }
        }
        if(leverState == EnumLeverState.ACTIVE) {
            if (leverPosition < 30f) {
                leverPosition += 5.0f;
            } else {
                leverPosition = 30f;
            }
        }
        if (this.dematTransit != null) {
            if (this.dematTransit.finished) {
                if(tardisID != null) {
                    if (this.getLevel() != null) {
                        if (!this.getLevel().isClientSide()) {
                            ServerWorld serverWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                            assert serverWorld != null;
                            PlayerEntity playerEntity = serverWorld.getNearestPlayer(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 60, false);
                            this.dematTransit.finished = false;
                            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                            tardis.landed = true;
                            this.dematTransit = null;
                            this.leverState = EnumLeverState.DEACTIVE;
                            if (tardis.landed != false) {
                                tardis.landed = false;
                            }
                            //System.out.println(tardis.landed);
                            syncToClient();
                        }
                    }
                }
                syncToClient();
            }

        }
        if(leverState == EnumLeverState.ACTIVE) {
            if (this.dematTransit != null) {
                if (this.dematTransit.readyForDemat) {
                    canPull = false;
                    ServerWorld serverWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
                    assert serverWorld != null;
                    PlayerEntity playerEntity = serverWorld.getNearestPlayer(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 60, false);
                    if (playerEntity != null) {
                        //delay -= 1;
                        //if (delay == 20) {
                            playerEntity.displayClientMessage(new TranslationTextComponent
                                    ("Flight remaining: " + (flightTicks * 100) / this.dematTransit.getFlightTicks() + "%").setStyle(Style.EMPTY.withColor(TextFormatting.WHITE).withItalic(true).withBold(true)), true);
                        //} else if (delay == 0) {
                        //    delay = 21;
                        //}

                    }
                    if (flightTicks == this.dematTransit.getFlightTicks()) {
                        this.dematTransit.isReadyForRemat = true;
                        flightTicks = 0;
                        this.dematTransit.readyForDemat = false;
                        canPull = true;
                        if(playerEntity != null) {
                            playerEntity.sendMessage(new TranslationTextComponent("TARDIS is ready for rematerialisation.").setStyle(Style.EMPTY.withColor(TextFormatting.AQUA).withItalic(true)), UUID.randomUUID());
                        }
                    }
                    if (flightTicks < this.dematTransit.getFlightTicks()) {
                        flightTicks += 1;
                    }
                    // Ready to demat and run flight ticks
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
        this.leverState = EnumLeverState.values()[nbt.getInt("leverState")];
        if (nbt.contains("tardisID")) {
            tardisID = nbt.getUUID("tardisID");
        }
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("leverState", this.leverState.ordinal());
        if (tardisID != null ) {
            nbt.putUUID("tardisID", tardisID);
        }
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

    public ActionResultType useOn(World world, PlayerEntity playerEntity, BlockPos blockpos, Hand hand, BlockRayTraceResult pHit) {
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION) {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = blockstate.getBlock();
            BlockPos interiorDoorPos = tardis.interior_door_position;
            if (block instanceof TardisLeverBlock && hand == Hand.MAIN_HAND) {
                if(canPull) {
                    leverState = getNextLeverState();
                }
                //System.out.println(this.leverState);
                syncToClient();
                if (leverState == EnumLeverState.ACTIVE) {
                    tardis.landed = false;
                    if (flightTicks <= 5) {
                        if (this.dematTransit == null) {
                            changeMatStateFromLever();
                            playerEntity.sendMessage(new TranslationTextComponent(
                                    "Dematerialising...").setStyle(Style.EMPTY.withColor(TextFormatting.DARK_AQUA)), UUID.randomUUID());
                        }
                    }
                    syncToClient();
                    if (interiorDoorPos != null) {
                        assert tardisWorld != null;
                        BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                        if (basicInteriorDoorTile != null) {
                            basicInteriorDoorTile.setLockedState(true, EnumDoorState.CLOSED);
                            tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
                            syncToClient();
                        }
                    }
                    if (this.dematTransit != null) {
                        if (flightTicks >= this.dematTransit.getFlightTicks()) {
                            if (leverState == EnumLeverState.ACTIVE) {
                                this.leverState = getNextLeverState();
                                syncToClient();
                                AIT.tardisManager.rematerialize = true;
                                BlockPos exteriorPos = tardis.exterior_position;
                                assert tardisWorld != null;
                                TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(exteriorPos);
                                assert tardisTileEntity != null;
                                tardisWorld.playSound(null, tardis.center_position, AITSounds.TARDIS_LANDING.get(), SoundCategory.MASTER, 7, 1);
                                if (interiorDoorPos != null) {
                                    BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                                    if (basicInteriorDoorTile != null) {
                                        basicInteriorDoorTile.setLockedState(false, EnumDoorState.CLOSED);
                                        tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
                                        flightTicks = 0;
                                        syncToClient();
                                    }
                                }
                            }
                        } else if (flightTicks >= 10) {
                            playerEntity.sendMessage(new TranslationTextComponent(
                                    "TARDIS has not finished its journey!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), UUID.randomUUID());
                        }
                    }

                } else if(leverState == EnumLeverState.DEACTIVE && this.dematTransit != null && this.dematTransit.isReadyForRemat) {
                    tardisWorld.playSound(null, tardis.center_position, AITSounds.TARDIS_LANDING.get(), SoundCategory.MASTER, 7, 1);
                    this.dematTransit.landTardisPart2();
                    playerEntity.sendMessage(new TranslationTextComponent(
                            "Rematerialising...").setStyle(Style.EMPTY.withColor(TextFormatting.AQUA)), UUID.randomUUID());
                    syncToClient();
                }
            }
        }

        return ActionResultType.SUCCESS;
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

    public void onPlace(BlockState blockState1, World world, BlockPos blockPos) {
        if(tardisID != null) {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            AIT.tardisManager.setTardisTargetBlockPos(tardisID, tardis.exterior_position);
            AIT.tardisManager.setTargetDimensionForTardis(tardisID, tardis.exterior_dimension);
            AIT.tardisManager.setTardisExteriorFacing(tardisID,tardis.exterior_facing);
        }
    }
}
