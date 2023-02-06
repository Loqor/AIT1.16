package com.mdt.ait.common.tileentities;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.GBTCasingBlock;
import com.mdt.ait.common.blocks.TardisCoralBlock;
import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumCoralState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.enums.EnumMatState;
import io.mdt.ait.common.tiles.TARDISTileEntity;
import io.mdt.ait.tardis.TARDIS;
import io.mdt.ait.tardis.TARDISManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;
import java.util.UUID;

public class TardisCoralTile extends TileEntity implements ITickableTileEntity {

    protected EnumCoralState coralState = EnumCoralState.FIRST;
    private int ticks, pulses;
    private int run_once = 0;
    public TARDISTileEntity tte;
    public Direction facingDirection = Direction.NORTH;

    public TardisCoralTile() {
        super(AITTiles.TARDIS_CORAL_TILE_ENTITY_TYPE.get());
    }

    public EnumCoralState getNextCoralState() {
        switch (coralState) {
            case FIRST:
                return EnumCoralState.SECOND;
            case SECOND:
                return EnumCoralState.THIRD;
            case THIRD:
                return EnumCoralState.FOURTH;
            case FOURTH:
                return EnumCoralState.FIFTH;
            case FIFTH:
                return EnumCoralState.FINAL;
        }
        return EnumCoralState.FIRST;
    }

    public EnumCoralState getCoralState() {
        return this.coralState;
    }

    @Override
    public void tick() {
        TileEntity entity = level.getBlockEntity(worldPosition);
        BlockPos casingPos1 = new BlockPos(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ() - 1);
        BlockPos casingPos2 = new BlockPos(worldPosition.getX() + 1, worldPosition.getY(), worldPosition.getZ());
        BlockPos casingPos3 = new BlockPos(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ() + 1);
        BlockPos casingPos4 = new BlockPos(worldPosition.getX() - 1, worldPosition.getY(), worldPosition.getZ());
        BlockPos casingPos = casingPos1;
        if(getBlockState().getValue(TardisCoralBlock.FACING) == Direction.SOUTH) {
            casingPos = casingPos1;
        }
        if(getBlockState().getValue(TardisCoralBlock.FACING) == Direction.WEST) {
            casingPos = casingPos2;
        }
        if(getBlockState().getValue(TardisCoralBlock.FACING) == Direction.NORTH) {
            casingPos = casingPos3;
        }
        if(getBlockState().getValue(TardisCoralBlock.FACING) == Direction.EAST) {
            casingPos = casingPos4;
        }
        if (level.canSeeSky(worldPosition) && (level.getBlockState(casingPos).getBlock() instanceof GBTCasingBlock)) {
            ++ticks;
            if (ticks == 37/*750*/) {
                this.coralState = EnumCoralState.SECOND;
                level.playSound(null, worldPosition, SoundType.BAMBOO.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 75/*1500*/) {
                this.coralState = EnumCoralState.THIRD;
                level.playSound(null, worldPosition, SoundType.BAMBOO.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 112/*2250*/) {
                this.coralState = EnumCoralState.FOURTH;
                level.playSound(null, worldPosition, SoundType.BAMBOO.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 150/*3000*/) {
                this.coralState = EnumCoralState.FIFTH;
                level.playSound(null, worldPosition, SoundType.BAMBOO.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 187/*3750*/) {
                this.coralState = EnumCoralState.FINAL;
                level.playSound(null, worldPosition, SoundType.BAMBOO.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks >= 300/*6000*/) {  //6000 is 5 minutes
                if (!level.isClientSide) {
                    switchDirectionForTARDIS();
                    if (run_once == 0) {
                        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, entity.getLevel());
                        bolt.setPos(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ());
                        level.addFreshEntity(bolt);
                        //level.addParticle(ParticleTypes.CLOUD,worldPosition.getX(),worldPosition.getY() + 3, worldPosition.getZ(), 10, 10, 10);
                        try {
                            TARDIS tardis = TARDISManager.create(worldPosition, entity.getLevel().dimension());
                            TARDISTileEntity tardisTileEntity = (TARDISTileEntity) level.getBlockEntity(worldPosition);
                            /*tardisTileEntity.linkedTardis = tardis; FIXME: this
                            tardisTileEntity.linkedTardisId = tardis.tardisId;
                            tardisTileEntity.matState = EnumMatState.REMAT;
                            tardis.exteriorFacing = facingDirection;
                            tardisTileEntity.currentexterior = EnumExteriorType.HELLBENT_TT_CAPSULE;*///pickRandomExterior();
                            syncToClient();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        run_once = 1;
                    }
                }
            }
        } else if (level.canSeeSky(worldPosition) && !(level.getBlockState(casingPos).getBlock() instanceof GBTCasingBlock)) {
            ++ticks;
            if (ticks == 750) {
                this.coralState = EnumCoralState.SECOND;
                level.playSound(null, worldPosition, SoundType.METAL.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 1500) {
                this.coralState = EnumCoralState.THIRD;
                level.playSound(null, worldPosition, SoundType.METAL.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 2250) {
                this.coralState = EnumCoralState.FOURTH;
                level.playSound(null, worldPosition, SoundType.METAL.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 3000) {
                this.coralState = EnumCoralState.FIFTH;
                level.playSound(null, worldPosition, SoundType.METAL.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks == 3750) {
                this.coralState = EnumCoralState.FINAL;
                level.playSound(null, worldPosition, SoundType.METAL.getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            if (ticks >= 6000) {  //6000 is 5 minutes
                if (!level.isClientSide) {
                    switchDirectionForTARDIS();
                    if (run_once == 0) {
                        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, entity.getLevel());
                        bolt.setPos(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ());
                        level.addFreshEntity(bolt);
                        //level.addParticle(ParticleTypes.CLOUD,worldPosition.getX(),worldPosition.getY() + 3, worldPosition.getZ(), 10, 10, 10);
                        try {
                            /*Tardis tardis = tardisManager.createNewTardis(UUID.randomUUID(), worldPosition, entity.getLevel().dimension());
                            TardisTileEntity tardisTileEntity = (TardisTileEntity) level.getBlockEntity(worldPosition);
                            assert tardisTileEntity != null;
                            tardisTileEntity.linkedTardis = tardis;
                            tardisTileEntity.linkedTardisId = tardis.tardisId;
                            tardisTileEntity.matState = EnumMatState.REMAT;
                            tardis.exteriorFacing = facingDirection;
                            tardisTileEntity.currentexterior = EnumExteriorType.HELLBENT_TT_CAPSULE;//pickRandomExterior();
                            syncToClient();*/ // FIXME: this
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        run_once = 1;
                    }
                }
            }
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("coralState", this.coralState.ordinal());
        return super.save(nbt);
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.coralState = EnumCoralState.values()[nbt.getInt("coralState")];
        super.load(pState, nbt);
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

    public boolean switchDirectionForTARDIS() {
        BlockState blockState = level.getBlockState(worldPosition);
        TileEntity entity = level.getBlockEntity(worldPosition);
        switch (blockState.getValue(TardisCoralBlock.FACING)) {
            case NORTH:
                return level.setBlock(worldPosition, AITBlocks.TARDIS_BLOCK.get().defaultBlockState().rotate(entity.getLevel(), worldPosition, Rotation.NONE), 512);
            case EAST:
                return level.setBlock(worldPosition, AITBlocks.TARDIS_BLOCK.get().defaultBlockState().rotate(entity.getLevel(), worldPosition, Rotation.CLOCKWISE_90), 512);
            case SOUTH:
                return level.setBlock(worldPosition, AITBlocks.TARDIS_BLOCK.get().defaultBlockState().rotate(entity.getLevel(), worldPosition, Rotation.CLOCKWISE_180), 512);
            case WEST:
                return level.setBlock(worldPosition, AITBlocks.TARDIS_BLOCK.get().defaultBlockState().rotate(entity.getLevel(), worldPosition, Rotation.COUNTERCLOCKWISE_90), 512);
            default:
                throw new RuntimeException("Invalid facing direction in getCollisionShape() " +
                        "//HOW THE HECK DID YOU GET HERE??");
        }
    }

    public Direction exteriorFacingCoralBlock() {
        if(TardisCoralBlock.FACING.equals(Direction.NORTH)) {
            return facingDirection = Direction.NORTH;
        }
        if(TardisCoralBlock.FACING.equals(Direction.EAST)) {
            return facingDirection = Direction.EAST;
        }
        if(TardisCoralBlock.FACING.equals(Direction.SOUTH)) {
            return facingDirection = Direction.SOUTH;
        }
        if(TardisCoralBlock.FACING.equals(Direction.WEST)) {
            return facingDirection = Direction.WEST;
        }
        return facingDirection;
    }

    /*public EnumExteriorType pickRandomExterior() {
        return EnumExteriorType.values()[new Random().nextInt(EnumExteriorType.values().length)];
    }*/

    public void syncToClient() {
        assert level != null;
        level.setBlocksDirty(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition));
        level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        setChanged();
    }
}