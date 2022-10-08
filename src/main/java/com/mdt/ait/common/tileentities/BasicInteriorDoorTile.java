package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.tardis.Tardis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.ForgeChunkManager;

import java.util.UUID;

import static com.mdt.ait.common.blocks.BasicInteriorDoorBlock.FACING;
import static com.mdt.ait.core.init.enums.EnumDoorState.*;
import static com.mdt.ait.core.init.enums.EnumDoorState.BOTH;

public class BasicInteriorDoorTile extends TileEntity implements ITickableTileEntity {

    public float leftDoorRotation = 0;
    public float rightDoorRotation = 0;

    public UUID tardisID;
    public Tardis linked_tardis;
    protected EnumDoorState currentstate = CLOSED;
    public EnumDoorState previousstate = CLOSED;

    public BasicInteriorDoorTile(TileEntityType<TileEntity> entity) {
        super(entity);
    }

    public EnumDoorState currentState() {
        return this.currentstate;
    }

    /*public EnumDoorState getNextDoorState() {
        switch (currentstate) {
            case CLOSED:
                return FIRST;
            case FIRST:
                return BOTH;
            case BOTH:
                return CLOSED;
            case LOCKED:
                return CLOSED;
        }
        return CLOSED;
    }*/

    /*public void setDoorState(EnumDoorState state) {
        this.currentstate = state;
    }*/

    @Override public void tick() {
//        System.out.println(currentstate);
        AxisAlignedBB aabb = getTardisInteriorDoorCollider(getBlockState()).bounds();
        aabb = aabb.inflate(0.8D/16D).move(getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ());
        this.level.getEntities(null, aabb).forEach(this::entityInside);

        if (currentState() != previousstate) {
            rightDoorRotation = currentState() == FIRST ? 0.0f : 87.5f;
            leftDoorRotation = currentState() == FIRST ? 0.0f : (currentState() == BOTH ? 0.0f : 87.5f);
        }
        if (currentState() != CLOSED) {
            if (rightDoorRotation < 87.5f) {
                rightDoorRotation += 5.0f;
            } else {
                rightDoorRotation = 87.5f;
            }
            if (currentState() == BOTH) {
                if (leftDoorRotation < 87.5f) {
                    leftDoorRotation += 5.0f;
                } else {
                    leftDoorRotation = 87.5f;
                }
            }
        } else {
            if (leftDoorRotation > 0.0f && rightDoorRotation > 0.0f) {
                leftDoorRotation -= 15.0f;
                rightDoorRotation -= 15.0f;
            }
        }
        if(currentState() == CLOSED) {
            if(leftDoorRotation == -2.5f) {
                leftDoorRotation = 0.0f;
            }
            if(rightDoorRotation == -2.5f) {
                rightDoorRotation = 0.0f;
            }
        }
        if(currentState() == LOCKED) {
            leftDoorRotation = 0.0f;
            rightDoorRotation = 0.0f;
        }
        //System.out.println("Right Door Rotation: "+ rightDoorRotation + " || " + "Left Door Rotation: " + leftDoorRotation);
        //previousstate = currentState();
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    private void entityInside(Entity entity) {
        World world = entity.level;
        if (!world.isClientSide()) {
            if (linked_tardis != null) {
                if (currentstate != CLOSED && entity instanceof ServerPlayerEntity) {
                    ServerWorld exteriorWorld = AIT.server.getLevel(linked_tardis.exterior_dimension);
                    assert exteriorWorld != null;
                    ForgeChunkManager.forceChunk(exteriorWorld, AIT.MOD_ID, linked_tardis.exterior_position, 0, 0, true, true);
                    linked_tardis.teleportToExterior((PlayerEntity) entity);
                    syncToClient();
                }
            }
        }
    }

    public Tardis getInteriorID() {
        return linked_tardis;
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
                if (this.currentstate == CLOSED)
                    world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (this.currentstate == FIRST)
                    world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (this.currentstate == BOTH)
                    world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                syncToClient();
            } else {
                if (currentState() != FIRST)
                    world.playSound(null, blockpos, AITSounds.POLICE_BOX_CLOSE.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (currentState() == FIRST)
                    world.playSound(null, blockpos, AITSounds.POLICE_BOX_OPEN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                syncToClient();
            }
        return ActionResultType.SUCCESS;
    }



    @Override public void load(BlockState pState, CompoundNBT nbt) {
        System.out.println("Door load");
        this.currentstate = EnumDoorState.values()[nbt.getInt("currentstate")];
        this.leftDoorRotation = nbt.getFloat("leftDoorRotation");
        this.rightDoorRotation = nbt.getFloat("rightDoorRotation");
        if (nbt.contains("tardis_id")) {
            this.linked_tardis = AIT.tardisManager.getTardis(nbt.getUUID("tardis_id"));
        }
        super.load(pState, nbt);
    }
    @Override public CompoundNBT save(CompoundNBT nbt) {
        System.out.println("Door save");
        nbt.putInt("currentstate", this.currentstate.ordinal());
        nbt.putFloat("leftDoorRotation", this.leftDoorRotation);
        nbt.putFloat("rightDoorRotation", this.rightDoorRotation);
        System.out.println(this.currentstate);
        if (linked_tardis != null) {
            nbt.putUUID("tardis_id", linked_tardis.tardisID);
        }
        return super.save(nbt);
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
