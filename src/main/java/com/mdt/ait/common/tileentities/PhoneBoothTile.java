package com.mdt.ait.common.tileentities;

import com.mdt.ait.common.blocks.PhoneBoothBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumPhoneDoorState;
import com.qouteall.immersive_portals.teleportation.ClientTeleportationManager;
import com.qouteall.immersive_portals.teleportation.ServerTeleportationManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FallingDustParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;

import javax.annotation.Nonnull;

import static com.mdt.ait.core.init.enums.EnumDoorState.CLOSED;

public class PhoneBoothTile extends TileEntity implements ITickableTileEntity {

    public EnumPhoneDoorState currentstate = EnumPhoneDoorState.CLOSED;
    public EnumPhoneDoorState previousstate = EnumPhoneDoorState.CLOSED;

    public float mainDoorRotation = 0.0f;
    public float secondaryDoorRotation = 0.0f;
    public float makeBoothFall = 0.0f;
    public boolean atNewLocation = false;

    public PhoneBoothTile() {
        super(AITTiles.PHONE_BOOTH_TILE_ENTITY_TYPE.get());
    }

    public EnumPhoneDoorState getNextDoorState() {
        if (currentstate == EnumPhoneDoorState.CLOSED) {
            return EnumPhoneDoorState.FIRST;
        } else {
            return EnumPhoneDoorState.CLOSED;
        }
    }

    public void setDoorState(EnumPhoneDoorState state) {
        this.currentstate = state;
    }

    public EnumPhoneDoorState currentState() {
        return this.currentstate;
    }

    @Override
    public void tick() {
        if (currentState() != previousstate) {
            mainDoorRotation = currentState() == EnumPhoneDoorState.FIRST ? 0.0f : 85f;
        }
        if (currentState() != EnumPhoneDoorState.CLOSED) {
            if (mainDoorRotation < 85f) {
                mainDoorRotation += 5.0f;
            } else {
                mainDoorRotation = 85f;
            }
            if (secondaryDoorRotation < 175f) {
                secondaryDoorRotation += 10.0f;
            } else {
                secondaryDoorRotation = 175f;
            }
        } else {
            if(mainDoorRotation > 0.0f) {
                mainDoorRotation -= 15.0f;
            }
            if(secondaryDoorRotation > 0.0f) {
                secondaryDoorRotation -= 30.0f;
            }
        }
        if(currentState() == EnumPhoneDoorState.CLOSED) {
            if (mainDoorRotation <= -2.5f) {
                mainDoorRotation = 0.0f;
            }
            if (secondaryDoorRotation <= -2.5f) {
                secondaryDoorRotation = 0.0f;
            }
        }
        previousstate = currentState();
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(worldPosition).inflate(10, 10, 10);
    }

    public void useOn(World pLevel, PlayerEntity pPlayer, BlockPos pPos, Hand pHand) {
        BlockState blockstate = pLevel.getBlockState(pPos);
        Block block = blockstate.getBlock();
        if (block instanceof PhoneBoothBlock && pHand == Hand.MAIN_HAND && !pLevel.isClientSide) {
            this.setDoorState(this.getNextDoorState());
            pLevel.playSound(null, pPos, SoundEvents.IRON_DOOR_OPEN, SoundCategory.MASTER, 4, 1);
        }
        syncToClient();
    }

    public void entityInside(BlockState pState, World pLevel, BlockPos pPos, Entity pEntity) {
        if(pEntity instanceof PlayerEntity) {
            if(this.currentstate == EnumPhoneDoorState.FIRST) {
                System.out.println(pEntity.getDisplayName());
            /*LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, pLevel);
            bolt.setPos(pPos.getX() - 0.5, pPos.getY() + 2.5, pPos.getZ() - 0.5);
            pLevel.addFreshEntity(bolt);*/
                atNewLocation = true;
                pEntity.moveTo(pPos.getX() + 0.5, 128.125, pPos.getZ() + 0.5);
                this.setDoorState(EnumPhoneDoorState.CLOSED);
            }

            pLevel.addParticle(ParticleTypes.CLOUD, pPos.getX() + 0.5, pPos.getY() + 2.5, pPos.getZ() + 0.5, 0.1, 0.1, 0.1);
        }
        syncToClient();
    }

    @Override
    public void load(BlockState pState, CompoundNBT nbt) {
        this.currentstate = EnumPhoneDoorState.values()[nbt.getInt("currentstate")];
        super.load(pState, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("currentstate", this.currentstate.ordinal());
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
