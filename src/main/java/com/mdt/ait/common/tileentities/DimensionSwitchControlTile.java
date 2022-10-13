package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.DimensionSwitchControlBlock;
import com.mdt.ait.core.init.AITDimensions;
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

    public DimensionSwitchControlTile() {
        super(AITTiles.DIMENSION_SWITCH_CONTROL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        //System.out.println(currentdimensionstate);
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
        }
        return EnumDimensionControlState.EARTH;
    }

    public void changeDimensionFromControl() {
        if(currentdimensionstate == EnumDimensionControlState.EARTH) {
            newDimension = World.OVERWORLD;
        }
        if(currentdimensionstate == EnumDimensionControlState.NETHER) {
            newDimension = World.NETHER;
        }
        if(currentdimensionstate == EnumDimensionControlState.END) {
            newDimension = World.END;
        }
        if(currentdimensionstate == EnumDimensionControlState.GALLIFREY) {
            newDimension = AITDimensions.GALLIFREY;
        }
        if(currentdimensionstate == EnumDimensionControlState.MONDAS) {
            newDimension = AITDimensions.MONDAS;
        }
        if (tardisID != null) {
            AIT.tardisManager.setTargetDimensionForTardis(tardisID, newDimension);
        }

    }


    public ActionResultType useOn(World world, PlayerEntity playerEntity, BlockPos blockpos, Hand hand, BlockRayTraceResult pHit) {
//        Tardis tardis = AIT.tardisManager.getTardis(tardisID);
//        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof DimensionSwitchControlBlock && hand == Hand.MAIN_HAND) {
            //playerEntity.sendMessage(new TranslationTextComponent(
            //        "IS THIS WORKING?!").setStyle(Style.EMPTY.withColor(TextFormatting.YELLOW)), UUID.randomUUID());
            currentdimensionstate = getNextDimensionState();
            changeDimensionFromControl();
            syncToClient();
        }

        return ActionResultType.SUCCESS;
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
