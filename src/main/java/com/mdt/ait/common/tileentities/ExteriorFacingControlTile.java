package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.ExteriorFacingControlBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumExteriorFacingState;
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

public class ExteriorFacingControlTile extends TileEntity implements ITickableTileEntity {

    public UUID tardisID;
    public float exteriorFacingSetting = 0.0f;
    public EnumExteriorFacingState currentExteriorFacingSetting = EnumExteriorFacingState.NORTH;
    public Direction newFacingDirection;

    public ExteriorFacingControlTile() {
        super(AITTiles.EXTERIOR_FACING_CONTROL_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {

    }

    public EnumExteriorFacingState getNextExteriorFacingSetting() {
        switch(currentExteriorFacingSetting) {
            case NORTH:
                return EnumExteriorFacingState.EAST;
            case EAST:
                return EnumExteriorFacingState.SOUTH;
            case SOUTH:
                return EnumExteriorFacingState.WEST;
            case WEST:
                return EnumExteriorFacingState.NORTH;
        }
        return EnumExteriorFacingState.NORTH;
    }

    public void changeDirectionFromControl() {
        if(this.currentExteriorFacingSetting == EnumExteriorFacingState.NORTH) {
            this.newFacingDirection = Direction.NORTH;
        }
        if(this.currentExteriorFacingSetting == EnumExteriorFacingState.EAST) {
            this.newFacingDirection = Direction.EAST;
        }
        if(this.currentExteriorFacingSetting == EnumExteriorFacingState.SOUTH) {
            this.newFacingDirection = Direction.SOUTH;
        }
        if(this.currentExteriorFacingSetting == EnumExteriorFacingState.WEST) {
            this.newFacingDirection = Direction.WEST;
        }
        if (this.tardisID != null) {
            AIT.tardisManager.setTardisExteriorFacing(tardisID, newFacingDirection);
        }

    }

    public ActionResultType useOn(World world, PlayerEntity pPlayer, BlockPos pPos, Hand pHandIn, BlockRayTraceResult pHit) {
        BlockState blockstate = world.getBlockState(pPos);
        Block block = blockstate.getBlock();
        if (block instanceof ExteriorFacingControlBlock && pHandIn == Hand.MAIN_HAND) {
//            System.out.println("IM FUCKING HERE: " + getNextExteriorFacingSetting());
            this.currentExteriorFacingSetting = getNextExteriorFacingSetting();
        }
        changeDirectionFromControl();
        syncToClient();
        return ActionResultType.SUCCESS;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.exteriorFacingSetting = nbt.getFloat("exteriorFacingSetting");
        this.currentExteriorFacingSetting = EnumExteriorFacingState.values()[nbt.getInt("currentExteriorFacingSetting")];
        if (nbt.contains("tardisID")) {
            this.tardisID = nbt.getUUID("tardisID");
        }

        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        if (this.tardisID != null) {
            nbt.putUUID("tardisID", this.tardisID);
        }

        nbt.putInt("currentExteriorFacingSetting", this.currentExteriorFacingSetting.ordinal());
        nbt.putFloat("exteriorFacingSetting", this.exteriorFacingSetting);
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
