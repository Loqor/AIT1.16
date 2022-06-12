package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.events.CommonEventHandler;
import com.mdt.ait.helpers.tardis.Tardis;
import com.mdt.ait.helpers.tardis.TardisManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;

import javax.annotation.Nonnull;

import java.util.UUID;

import static com.mdt.ait.common.blocks.BasicInteriorDoorBlock.FACING;
import static com.mdt.ait.core.init.enums.EnumDoorState.*;
import static com.mdt.ait.core.init.enums.EnumDoorState.BOTH;

public class BasicInteriorDoorTile extends TileEntity implements ITickableTileEntity {

    public float leftDoorRotation = 0;
    public float rightDoorRotation = 0;
    protected EnumDoorState currentstate = CLOSED;
    public EnumDoorState previousstate = CLOSED;
    public UUID linked_tardis_id;
    public Tardis linked_tardis;

    public BasicInteriorDoorTile(TileEntityType entity) {
        super(entity);
    }

    public EnumDoorState currentState() {
        return this.currentstate;
    }

    public EnumDoorState getNextDoorState() {
        switch (currentstate) {
            case CLOSED:
                return FIRST;
            case FIRST:
                return BOTH;
            case BOTH:
                return CLOSED;
        }
        return CLOSED;
    }

    public void setDoorState(EnumDoorState state) {
        this.currentstate = state;
    }

    @Override public void tick() {
        AxisAlignedBB aabb = getTardisInteriorDoorCollider(getBlockState()).bounds();
        aabb = aabb.inflate(0.8D/16D).move(getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ());
        this.level.getEntities(null, aabb).forEach(this::entityInside);

        //System.out.println(previousstate + " " + currentState() + " " + getNextDoorState());
        if(currentState() != previousstate) {
            rightDoorRotation = currentState() == FIRST ? 0.0f : 87.5f;
            leftDoorRotation = currentState() == FIRST ? 0.0f : (currentState() == BOTH ? 0.0f : 87.5f);
        }
        if(currentState() != CLOSED) {
            if(rightDoorRotation < 87.5f){
                rightDoorRotation += 5.0f;
            } else {
                rightDoorRotation = 87.5f;
            }
            if(currentState() == BOTH) {
                if(leftDoorRotation < 87.5f){
                    leftDoorRotation += 5.0f;
                } else {
                    leftDoorRotation = 87.5f;
                }
            }
        } else {
            if(leftDoorRotation > 0.0f && rightDoorRotation > 0.0f) {
                leftDoorRotation -= 15.0f;
                rightDoorRotation -= 15.0f;
            }
        }
        previousstate = currentState();
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    private void entityInside(Entity entity) {
        //BlockPos bpos = linked_tardis.exterior_position;
        World world = entity.level;
        if(!world.isClientSide()) {
            if (currentstate != CLOSED && entity instanceof ServerPlayerEntity) {
                //TardisManager tardis_manager = TardisManager.getTardisManagerForWorld(level);
                //linked_tardis = tardis_manager.getTardis(linked_tardis_id);
                //ForgeChunkManager.forceChunk(world1, AIT.MOD_ID, new BlockPos(0, 128, 0), 0, 0, true, true);
                System.out.println("YOU\'RE TOUCHING ME AHHHHHHHH INSIDE");
                //((ServerPlayerEntity) entity).teleportTo(world1, bpos, bpos, bpos, entity.yRot, entity.xRot);
                //entity.moveTo(entity.getX(), entity.getY() * 2, entity.getZ());
                //System.out.println("ServerPlayerEntity stuff");
                syncToClient();
            }
        }
    }

    private VoxelShape getTardisInteriorDoorCollider(BlockState blockstate) {
        switch(blockstate.getValue(FACING)) {
            case NORTH:
                return TardisBlock.NORTH_AABB;
            case EAST:
                return TardisBlock.EAST_AABB;
            case SOUTH:
                return TardisBlock.SOUTH_AABB;
            case WEST:
                return TardisBlock.WEST_AABB;
            default:
                throw new RuntimeException("Invalid facing direction in getCollisionShape() " +
                        "//HOW THE HECK DID YOU GET HERE??");
        }
    }

    public BasicInteriorDoorTile() {
        super(AITTiles.BASIC_INTERIOR_DOOR_TILE_ENTITY_TYPE.get());
    }

    public ActionResultType useOn(World world, PlayerEntity playerentity, BlockPos blockpos, Hand hand) {
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block instanceof BasicInteriorDoorBlock && hand == Hand.MAIN_HAND && !world.isClientSide) {
            this.setDoorState(this.getNextDoorState());
            if (this.getNextDoorState() == FIRST)
                world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            else
                world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(),SoundCategory.BLOCKS, 1.0F, 1.0F);
            syncToClient();
        }
        return ActionResultType.SUCCESS;
    }

    @Override public void load(BlockState pState, CompoundNBT nbt) {
        currentstate = EnumDoorState.values()[nbt.getInt("currentstate")];
        leftDoorRotation = nbt.getFloat("leftDoorRotation");
        rightDoorRotation = nbt.getFloat("rightDoorRotation");
        super.load(pState, nbt);
    }
    @Override public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentstate", currentstate.ordinal());
        nbt.putFloat("leftDoorRotation", leftDoorRotation);
        nbt.putFloat("rightDoorRotation", rightDoorRotation);
        return super.save(nbt);
    }

    @Override @Nonnull
    public CompoundNBT getUpdateTag() {
        return save(new CompoundNBT());
    }
    @Override public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(worldPosition, 0, save(new CompoundNBT()));
    }
    @Override public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        load(getBlockState(), packet.getTag());
    }

    public void syncToClient() {
        level.setBlocksDirty(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition));
        level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        setChanged();
    }
}
