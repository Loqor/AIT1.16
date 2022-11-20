package com.mdt.ait.common.entities;

import com.mdt.ait.core.init.AITItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class DeloreanEntity extends CreatureEntity implements IMob {
    private static final DataParameter<Byte> DATA_ID_FLAGS = EntityDataManager.defineId(BatEntity.class, DataSerializers.BYTE);
    public boolean isDriverDoorOpen;
    public boolean canEnterCar;
    public boolean continueAntiGrav;
    public float doorPosition;
    public float newYPositions = -13.9722F;//23;
    public float doorNewYPositions = 7.0278f;
    public boolean isSetToFly;
    public boolean isActivelyDriving = false;

    public DeloreanEntity(EntityType<? extends CreatureEntity> p_i50290_1_, World p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_FLAGS, (byte)0);
    }

    protected float getSoundVolume() {
        return 0F;
    }

    protected float getVoicePitch() {
        return 0;
    }

    @Nullable
    public SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BAT_DEATH;
    }

    public boolean canCollideWith(Entity pEntity) {
        return canVehicleCollide(this, pEntity);
    }

    public static boolean canVehicleCollide(Entity pVehicle, Entity pEntity) {
        return (pEntity.canBeCollidedWith() || pEntity.isPushable()) && !pVehicle.isPassengerOfSameVehicle(pEntity);
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean isPushable() {
        return false;
    }

    protected void doPush(Entity pEntity) {
        push(this);
    }

    protected void pushEntities() {
    }

    public void push(Entity pEntity) {
        if (pEntity instanceof DeloreanEntity) {
            if (pEntity.getBoundingBox().minY < getBoundingBox().maxY) {
                super.push(pEntity);
            }
        } else if (pEntity.getBoundingBox().minY <= getBoundingBox().minY) {
            super.push(pEntity);
        }

    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return CreatureEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20D);
    }

    public boolean isBeingRidden() {
        return !getPassengers().isEmpty();
    }

    @Override
    public void travel(Vector3d vector3d) {
        float inMotion = MathHelper.sqrt(getHorizontalDistanceSqr(getDeltaMovement()));
        boolean isBeingDriven = inMotion >= 0.01D;
        if (isAlive() && getHealth() > 5) {
            if (isBeingRidden() && canBeControlledByRider()) {
                if (getControllingPassenger() != null) {
                    LivingEntity livingentity = (LivingEntity) getControllingPassenger();
                    float forward = MathHelper.sqrt(livingentity.getHorizontalDistanceSqr(getDeltaMovement()));
                    setRot(yRot, xRot);
                    yRotO = yRot;
                    yHeadRot = yRotO;
                    maxUpStep = 1.0F;
                    if (isBeingDriven) {
                        yRot = livingentity.yRot;
                    }
                    if (forward >= 0.0F) {
                        forward *= 2F;
                    }
                    if (canBeControlledByRider()) {
                        if(!isNoGravity()) {
                            setSpeed(0.3f);
                        } else {
                            setSpeed(1f);
                            flyingSpeed = 0.35f;
                        }
                    if (livingentity.isSprinting()) {
                        isActivelyDriving = true;
                        if(isNoGravity()) {
                            super.travel(new Vector3d(0, vector3d.y, vector3d.x + (double) forward));
                            maxUpStep = 1.0F;
                        } else {
                            super.travel(new Vector3d(0, vector3d.y, vector3d.z + (double) forward));
                        }
                        super.travel(new Vector3d(0, vector3d.y, 0));
                        //continueAntiGrav = false;
                        }
                    } else {
                        isActivelyDriving = false;
                    }
                    if(isSetToFly) {
                        setNoGravity(true);
                        yRot = livingentity.yRot;
                        moveTo(getX(), getY() + 0.5F, getZ());
                    } else {
                        if(isNoGravity()) {
                            if(!this.level.getBlockState(this.blockPosition().below(5)).isAir()) {
                                moveTo(getX(), getY() + 5, getZ());
                            }
                            continueAntiGrav = true;
                        } else {
                            continueAntiGrav = false;
                        }
                    }
                }
            } else {
                setNoGravity(false);
                super.travel(vector3d);
            }
        }
    }

    public void positionRider(Entity entity) {
        if (getPassengers().size() > 0 && getPassengers().get(0) == entity) {
            Vector3d pos = (getLookAngle().yRot(-90).scale(-0.55)).add(getX(), getY() - 0.2125D, getZ());
            entity.setPos(pos.x, pos.y, pos.z);
        }
        if (getPassengers().size() > 1 && getPassengers().get(1) == entity) {
            Vector3d pos = (getLookAngle().yRot(90).scale(-0.55)).add(getX(), getY()  - 0.2125D, getZ());
            entity.setPos(pos.x, pos.y, pos.z);
        }
    }

    public double getPassengersRidingOffset() {
        return 0.1D;
        //GOOGOODOLLS
    }

    public void tick() {
        if(!getPassengers().isEmpty())
        if(this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) || isUnderWater()) {
            isSetToFly = true;
        } else {
            isSetToFly = false;
        }
        if(isNoGravity()) {
            //if(newYPositions < 24.5f && doorNewYPositions < 8.5278) {
            //    newYPositions += 0.25f;
            //    doorNewYPositions += 0.25f;
            //} else if (newYPositions > 23f && doorNewYPositions > 7.0278){
            //    newYPositions -= 0.25;
            //    doorNewYPositions -= 0.25;
            //}
            if(newYPositions < -12.4722F) {
                newYPositions += 0.25f;
            } else if(newYPositions >= -13.9722F) {
                newYPositions -= 0.25f;
            }
        }
        setCustomNameVisible(hasCustomName());
        boolean canMove = getHealth() > 15;
        if (getPassengers().isEmpty() && onGround) {
            setDeltaMovement(0, 0, 0);
        }
        setAirSupply(getMaxAirSupply());
        if(isDriverDoorOpen) {
            if(doorPosition > -72.5f) {
                doorPosition -= 5.0f;
            } else {
                doorPosition = -72.5f;
            }
        } else if(doorPosition < 0) {
            doorPosition += 5.0f;
        } else {
            doorPosition = 0f;
        }
        if(doorPosition == -72.5f) {
            canEnterCar = true;
        } else {
            canEnterCar = false;
        }
        super.tick();
    }

    private static int MAX_PASSENGERS = 2;

    @Override
    protected ActionResultType mobInteract(PlayerEntity player, Hand pHand) {
        System.out.println(isDriverDoorOpen);
        if(!player.isCrouching() && !player.isPassenger() && !isDriverDoorOpen) {
            isDriverDoorOpen = true;
        }
        if(canEnterCar && isDriverDoorOpen) {
            if (!player.isCrouching() && getPassengers().size() < MAX_PASSENGERS && player.getItemInHand(Hand.MAIN_HAND).isEmpty()) {
                player.startRiding(this);
            }
        }
        if((player.isCrouching() && isDriverDoorOpen && !player.isPassenger()) || (player.isPassenger() && isDriverDoorOpen)) {
            isDriverDoorOpen = false;
        }
        //if(isDriverDoorOpen) {
        //    if (!player.isCrouching() && getPassengers().size() < MAX_PASSENGERS && player.getItemInHand(pHand).isEmpty()) {
        //        player.startRiding(this);
        //    }
        //}
        if(player.isCrouching() && (player.getItemInHand(pHand).getItem() == AITItems.TENNANT_SONIC.get() || player.getItemInHand(pHand).getItem() == AITItems.WHITTAKER_SONIC.get())) {
            remove();
        }
        return super.mobInteract(player, pHand);
    }

    @Nullable
    @Override
    public Entity getControllingPassenger() {
        if (!getPassengers().isEmpty()) {
            return getPassengers().get(0);
        }
        return null;
    }

    @Override
    public boolean canBeControlledByRider() {
        return true;
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        this.hurtMarked = false;
        this.setDeltaMovement(0f, 0f, 0f);
        return super.hurt(pSource, 0);
    }

    public void readAdditionalSaveData(CompoundNBT pCompound) {
        super.readAdditionalSaveData(pCompound);
    }

    public void addAdditionalSaveData(CompoundNBT pCompound) {
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }
}
