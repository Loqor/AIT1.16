package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.DimensionSwitchControlBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.*;
import com.mdt.ait.tardis.Tardis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
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

import javax.annotation.Nonnull;
import java.util.UUID;

public class DimensionSwitchControlTile extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;
    public float spinny = 0;
    public EnumDimensionControlState currentdimensionstate = EnumDimensionControlState.EARTH;
    private RegistryKey<World> newDimension;
    public boolean canChangeDim = false;

    public DimensionSwitchControlTile() {
        super(AITTiles.DIMENSION_SWITCH_CONTROL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        if(this.tardisID != null) {
            if (this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    Tardis tardis = AIT.tardisManager.getTardis(this.tardisID);
                    ServerWorld ExteriorWorld = AIT.server.getLevel(tardis.exterior_dimension);
                    if (!canChangeDim) {
                        if (newDimension == null) {
                            newDimension = tardis.target_dimension;
                            if (ExteriorWorld.getBlockEntity(tardis.exterior_position) != null) {
                                if(tardis.exterior_dimension != tardis.target_dimension) {
                                    newDimension = tardis.exterior_dimension;
                                } else {
                                    if (tardis.exterior_dimension == AIT.server.overworld().dimension()) {
                                        currentdimensionstate = EnumDimensionControlState.EARTH;
                                        syncToClient();
                                    }
                                    if (tardis.exterior_dimension == AIT.server.getLevel(World.NETHER).dimension()) {
                                        currentdimensionstate = EnumDimensionControlState.NETHER;
                                        syncToClient();
                                    }
                                    if (tardis.exterior_dimension == AIT.server.getLevel(World.END).dimension()) {
                                        currentdimensionstate = EnumDimensionControlState.END;
                                        syncToClient();
                                    }
                                    if (tardis.exterior_dimension == AIT.server.getLevel(AITDimensions.GALLIFREY).dimension()) {
                                        currentdimensionstate = EnumDimensionControlState.GALLIFREY;
                                        syncToClient();
                                    }
                                    if (tardis.exterior_dimension == AIT.server.getLevel(AITDimensions.MONDAS).dimension()) {
                                        currentdimensionstate = EnumDimensionControlState.MONDAS;
                                        syncToClient();
                                    }
                                }
                            }
                        }
                    }
                    if (ExteriorWorld.getBlockEntity(tardis.exterior_position) == null) {
                        canChangeDim = false;
                    }
                }
            }
        }
        syncToClient();
        //System.out.println(currentdimensionstate + "  |  " + newDimension);
    }

    public EnumDimensionControlState currentDimensionState() {
        return currentdimensionstate;
    }

    public EnumDimensionControlState getNextDimensionState() {
        switch(currentdimensionstate) {
            case EARTH:
                return EnumDimensionControlState.NETHER;
            case NETHER:
                return EnumDimensionControlState.END;
            case END:
                return EnumDimensionControlState.GALLIFREY;
            case GALLIFREY:
                return EnumDimensionControlState.MONDAS;
            case MONDAS:
                return EnumDimensionControlState.EARTH;
        }
        return EnumDimensionControlState.EARTH;
    }

    public void changeDimensionFromControl() {
        if(this.tardisID != null) {
            if (this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    if (currentdimensionstate == EnumDimensionControlState.EARTH) {
                        newDimension = World.OVERWORLD;
                    }
                    if (currentdimensionstate == EnumDimensionControlState.NETHER) {
                        newDimension = World.NETHER;
                    }
                    if (currentdimensionstate == EnumDimensionControlState.END) {
                        newDimension = World.END;
                    }
                    if (currentdimensionstate == EnumDimensionControlState.GALLIFREY) {
                        newDimension = AITDimensions.GALLIFREY;
                    }
                    if (currentdimensionstate == EnumDimensionControlState.MONDAS) {
                        newDimension = AITDimensions.MONDAS;
                    }
                    AIT.tardisManager.setTargetDimensionForTardis(tardisID, newDimension);
                }
            }
        }
    }

    public ActionResultType useOn(World world, PlayerEntity playerEntity, BlockPos blockpos, Hand hand, BlockRayTraceResult pHit) {
        canChangeDim  = true;
//        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
//        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if(this.tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    if (block instanceof DimensionSwitchControlBlock && hand == Hand.MAIN_HAND) {
                        //playerEntity.sendMessage(new TranslationTextComponent(
                        //        "IS THIS WORKING?!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), UUID.randomUUID());
                        currentdimensionstate = getNextDimensionState();
                        playerEntity.playSound(AITSounds.BUTTON_PRESS.get(), 5, 1);
                        changeDimensionFromControl();
                        syncToClient();
                    }
                }
            }
        }

        return ActionResultType.SUCCESS;
    }

    public void onPlace() {
        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        newDimension = tardis.exterior_dimension;
        if(tardis.exterior_dimension == AIT.server.overworld().dimension()) {
            currentdimensionstate = EnumDimensionControlState.EARTH;
        }
        if(tardis.exterior_dimension == AIT.server.getLevel(World.NETHER).dimension()) {
            currentdimensionstate = EnumDimensionControlState.NETHER;
        }
        if(tardis.exterior_dimension == AIT.server.getLevel(World.END).dimension()) {
            currentdimensionstate = EnumDimensionControlState.END;
        }
        if(tardis.exterior_dimension == AIT.server.getLevel(AITDimensions.GALLIFREY).dimension()) {
            currentdimensionstate = EnumDimensionControlState.GALLIFREY;
        }
        if(tardis.exterior_dimension == AIT.server.getLevel(AITDimensions.MONDAS).dimension()) {
            currentdimensionstate = EnumDimensionControlState.MONDAS;
        }
        changeDimensionFromControl();
        syncToClient();
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.currentdimensionstate = EnumDimensionControlState.values()[nbt.getInt("currentdimensionstate")];
        if (nbt.contains("tardisID")) {
            this.tardisID = nbt.getUUID("tardisID");
        }

        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentdimensionstate", this.currentdimensionstate.ordinal());
        if (this.tardisID != null) {
            nbt.putUUID("tardisID", this.tardisID);
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