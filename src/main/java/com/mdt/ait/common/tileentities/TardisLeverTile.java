package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisLeverBlock;
import com.mdt.ait.core.init.AITDimensions;
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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
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
    public Tardis linked_tardis;
    public ServerWorld lever_dim;
    public double waiting_for_flight = 0;
    public int runafter = 0;

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



    @Override
    public void tick() {
        TardisManager tardisManager = AIT.tardisManager;
        TileEntity entity = level.getBlockEntity(worldPosition);
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
                this.linked_tardis.positionForTardisChange();
                runafter = 0;
            }
        }
        System.out.println(runafter);
        System.out.println(linked_tardis);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.leverState = EnumLeverState.values()[nbt.getInt("leverState")];
        if (level != null) {
            if (!level.isClientSide()) { // Server Side Only
                this.linked_tardis = AIT.tardisManager.getTardis(linked_tardis.tardisID);
            }
        }
        if (this.linked_tardis.tardisID == null) {
            System.out.println("Linked Tardis ID is null");
        }
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("leverState", this.leverState.ordinal());
        if (this.linked_tardis.tardisID != null) {
            nbt.putUUID("tardisUUID", this.linked_tardis.tardisID);
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
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof TardisLeverBlock && hand == Hand.MAIN_HAND && !world.isClientSide) {
            leverState = getNextLeverState();
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
}
