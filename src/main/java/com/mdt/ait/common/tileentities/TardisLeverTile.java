package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisLeverBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumLeverState;
import com.mdt.ait.core.init.enums.EnumMatState;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.TardisManager;
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

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.UUID;

import static com.mdt.ait.core.init.enums.EnumDoorState.CLOSED;

public class TardisLeverTile extends TileEntity implements ITickableTileEntity {

    public EnumLeverState leverState = EnumLeverState.DEACTIVE;
    public float leverPosition = 0;
    public ServerWorld lever_dim;
    public double waiting_for_flight = 0;
    public int runafter = 0;
    public int run_once = 0;
    public UUID tardisID;
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

    public EnumLeverState getLeverState() {
        return this.leverState;
    }

    public void changeMatStateFromLever() {
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        ServerWorld world = AIT.server.getLevel(tardis.exterior_dimension);
        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        BlockPos exteriorPos = tardis.exterior_position;
        assert world != null;
        assert tardisWorld != null;
        TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(exteriorPos);
        assert tardisTileEntity != null;
        if(leverState == EnumLeverState.ACTIVE) {
            tardisWorld.playSound(null,tardis.center_position, AITSounds.TARDIS_TAKEOFF.get(), SoundCategory.MASTER,7,1);
            tardisTileEntity.matState = EnumMatState.DEMAT;
                AIT.tardisManager.moveTARDIS(tardisID, new BlockPos(worldPosition.getX() + 5, worldPosition.getY(), worldPosition.getZ() + 5), tardis.exterior_facing, tardis.exterior_dimension);
        } //else {
          //  tardisTileEntity.matState = EnumMatState.REMAT;
        //}
    }

    @Override
    public void tick() {
        if(leverState == EnumLeverState.DEACTIVE) {
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
        if(leverState == EnumLeverState.ACTIVE) {
            runafter = 1;
            if(runafter == 1) {
                runafter = 0;
                //PUT STUFF HERE
            }
        }
        if(leverState == EnumLeverState.ACTIVE && flightTicks < 360) {
            flightTicks += 1;
        }
        //System.out.println("Flight Ticks: " + flightTicks);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.leverState = EnumLeverState.values()[nbt.getInt("leverState")];
        this.tardisID = nbt.getUUID("tardisID");
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("leverState", this.leverState.ordinal());
        System.out.println(tardisID);
        nbt.putUUID("tardisID", this.tardisID);
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
            if (block instanceof TardisLeverBlock && hand == Hand.MAIN_HAND && !world.isClientSide) {
                if(flightTicks <= 5) {
                    this.leverState = getNextLeverState();
                    changeMatStateFromLever();
                }
                syncToClient();
                if(interiorDoorPos != null) {
                    BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                    if (basicInteriorDoorTile != null) {
                        basicInteriorDoorTile.setLockedState(true);
                        tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER,7,1);
                        syncToClient();
                    }
                }
                if(flightTicks >= 360) {
                    if (leverState == EnumLeverState.ACTIVE) {
                        this.leverState = getNextLeverState();
                        AIT.tardisManager.rematerialize = true;
                        BlockPos exteriorPos = tardis.exterior_position;
                        assert tardisWorld != null;
                        TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(exteriorPos);
                        assert tardisTileEntity != null;
                        tardisWorld.playSound(null, tardis.center_position, AITSounds.TARDIS_LANDING.get(), SoundCategory.MASTER, 7, 1);
                        if (interiorDoorPos != null) {
                            BasicInteriorDoorTile basicInteriorDoorTile = (BasicInteriorDoorTile) tardisWorld.getBlockEntity(interiorDoorPos);
                            if (basicInteriorDoorTile != null) {
                                basicInteriorDoorTile.setLockedState(false);
                                tardisWorld.playSound(null, interiorDoorPos, AITSounds.TARDIS_LOCK.get(), SoundCategory.MASTER, 7, 1);
                                flightTicks = 0;
                                syncToClient();
                            }
                        }
                    }
                } else {
                    playerEntity.sendMessage(new TranslationTextComponent(
                            "TARDIS has not finished its journey! Time remaining: " + flightTicks).setStyle(Style.EMPTY.withColor(TextFormatting.BLUE)), UUID.randomUUID());
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
}
