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
    public TardisTileEntity tardisTileEntity;

    public TardisLeverTile() {
        super(AITTiles.TARDIS_LEVER_TILE_ENTITY_TYPE.get());
    }

    public EnumLeverState getNextleverState() {
        switch (this.leverState) {
            case DEACTIVE:
                return EnumLeverState.ACTIVE;
            case ACTIVE:
                return EnumLeverState.DEACTIVE;
        }
        return EnumLeverState.DEACTIVE;
    }

    public EnumLeverState getPreviousleverState() {
        switch (this.leverState) {
            case ACTIVE:
                return EnumLeverState.DEACTIVE;
            case DEACTIVE:
                return EnumLeverState.ACTIVE;
        }
        return EnumLeverState.ACTIVE;
    }

    public EnumLeverState getleverState() {
        return this.leverState;
    }

    public void setleverState(EnumLeverState state) {
        this.leverState = state;
    }

    private void changeMatStateFromLever() {
        if(tardisID != null) {
            if(this.getLevel() != null) {
                if (!this.getLevel().isClientSide()) {
                    this.tardisTileEntity.updateMatState(this.getLevel());
                }
            }
        }
    }

    private EnumLeverState landedToleverState() {
        //System.out.println(tardis.landed);
        if (this.tardisTileEntity == null) {
            return EnumLeverState.DEACTIVE;
        }
        if (this.tardisTileEntity.lever_activated) {
            return EnumLeverState.ACTIVE;
        } else {
            return EnumLeverState.DEACTIVE;
        }
    }


    @Override
    public void tick() {
        if (this.tardisID != null) {
            this.leverState = landedToleverState();
            //System.out.println(this.leverState);
        }
        if (this.leverState == EnumLeverState.DEACTIVE) {
            if (leverPosition > 0f) {
                leverPosition -= 15.0f;
            } else {
                leverPosition = 0f;
            }
        }
        if(this.leverState == EnumLeverState.ACTIVE) {
            if (leverPosition < 30f) {
                leverPosition += 5.0f;
            } else {
                leverPosition = 30f;
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
            this.tardisID = nbt.getUUID("tardisID");
        }
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("leverState", this.leverState.ordinal());
        if (this.tardisID != null ) {
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

    public ActionResultType useOn(World world, PlayerEntity playerEntity, BlockPos blockpos, Hand hand, BlockRayTraceResult pHit) {
        if (!world.isClientSide && world.dimension() == AITDimensions.TARDIS_DIMENSION) {
            Tardis tardis = AIT.tardisManager.getTardis(tardisID);
            World exteriorWorld = AIT.server.getLevel(tardis.exterior_dimension);
            this.tardisTileEntity = (TardisTileEntity) exteriorWorld.getBlockEntity(tardis.exterior_position);
            this.tardisTileEntity.checkMatStatus(world,playerEntity,blockpos,hand,pHit);
            syncToClient();
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
            World exteriorWorld = AIT.server.getLevel(tardis.exterior_dimension);
            this.tardisTileEntity = (TardisTileEntity) exteriorWorld.getBlockEntity(tardis.exterior_position);
        }
    }
}
