/*package com.mdt.ait.common.entities;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITEntities;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.enums.EnumDimensionControlState;
import com.mdt.ait.core.init.enums.EnumExteriorFacingState;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.special.DematTransit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.client.CSteerBoatPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class DeloreanEntity extends Entity {
    private static final DataParameter<Byte> DATA_ID_FLAGS = EntityDataManager.defineId(DeloreanEntity.class, DataSerializers.BYTE);
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;

    public DeloreanEntity(EntityType<? extends Entity> p_i50290_1_, World p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public DeloreanEntity(World level, double x, double y, double z) {
        this(AITEntities.DELOREAN.get(), level);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vector3d.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_ID_FLAGS, (byte)0);
    }

    @OnlyIn(Dist.CLIENT)
    public void lerpTo(double pX, double pY, double pZ, float pYRot, float pXRot, int pLerpSteps, boolean pTeleport) {
        this.lerpX = pX;
        this.lerpY = pY;
        this.lerpZ = pZ;
        this.lerpYRot = (double)pYRot;
        this.lerpXRot = (double)pXRot;
        this.lerpSteps = 10;
    }

    public boolean isPushable() {
        return true;
    }

    public boolean canBeControlledByRider() {
        return this.getControllingPassenger() instanceof LivingEntity;
    }

    @Override
    public void absMoveTo(double pX, double pY, double pZ) {
        if (this.isAlive()) {
            if (this.isVehicle() && this.canBeControlledByRider()) {
                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
                this.yRot = livingentity.yRot;
                this.yRotO = this.yRot;
                this.xRot = livingentity.xRot * 0.5F;
                this.setRot(this.yRot, this.xRot);
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                float f2 = livingentity.yya;

                if (this.onGround) {
                    f = 0.0F;
                    f1 = 0.0F;
                    f2 = 0.0f;
                }

                if (this.isControlledByLocalInstance()) {
                    super.absMoveTo(f, f2, f1);
                } else if (livingentity instanceof PlayerEntity) {
                    this.setDeltaMovement(Vector3d.ZERO);
                }
            } else {
                super.absMoveTo(this.getX(), this.getY(), this.getZ());
            }
        }
        super.absMoveTo(pX, pY, pZ);
    }

    public void tick() {
        this.tickLerp();
        if(this.getControllingPassenger() instanceof PlayerEntity) {
            if (!this.level.isClientSide && this.getControllingPassenger().isShiftKeyDown()) {
                this.ejectPassengers();
            }
        }

        this.checkInsideBlocks();
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate((double)0.2F, (double)-0.01F, (double)0.2F), EntityPredicates.pushableBy(this));
        if (!list.isEmpty()) {
            boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof PlayerEntity);

            for(int j = 0; j < list.size(); ++j) {
                Entity entity = list.get(j);
                if (!entity.hasPassenger(this)) {
                    if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterMobEntity) && !(entity instanceof PlayerEntity)) {
                        entity.startRiding(this);
                    } else {
                        this.push(entity);
                    }
                }
            }
        }
    }



    public ActionResultType interact(PlayerEntity pPlayer, Hand pHand) {
        if (!this.level.isClientSide) {
            return pPlayer.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.PASS;
        } else {
            return ActionResultType.SUCCESS;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void onPassengerTurned(Entity pEntityToUpdate) {
        this.clampRotation(pEntityToUpdate);
    }

    protected void clampRotation(Entity pEntityToUpdate) {
        pEntityToUpdate.setYBodyRot(this.yRot);
        float f = MathHelper.wrapDegrees(pEntityToUpdate.yRot - this.yRot);
        float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
        pEntityToUpdate.yRotO += f1 - f;
        pEntityToUpdate.yRot += f1 - f;
        pEntityToUpdate.setYHeadRot(pEntityToUpdate.yRot);
    }

    public boolean canCollideWith(Entity pEntity) {
        return canVehicleCollide(this, pEntity);
    }

    public static boolean canVehicleCollide(Entity pVehicle, Entity pEntity) {
        return (pEntity.canBeCollidedWith() || pEntity.isPushable()) && !pVehicle.isPassengerOfSameVehicle(pEntity);
    }

    protected boolean isMovementNoisy() {
        return false;
    }

    public boolean causeFallDamage(float pFallDistance, float pDamageMultiplier) {
        return false;
    }

    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    private void tickLerp() {
        if (this.isControlledByLocalInstance()) {
            this.lerpSteps = 0;
            this.setPacketCoordinates(this.getX(), this.getY(), this.getZ());
        }

        if (this.lerpSteps > 0) {
            double d0 = this.getX() + (this.lerpX - this.getX()) / (double)this.lerpSteps;
            double d1 = this.getY() + (this.lerpY - this.getY()) / (double)this.lerpSteps;
            double d2 = this.getZ() + (this.lerpZ - this.getZ()) / (double)this.lerpSteps;
            double d3 = MathHelper.wrapDegrees(this.lerpYRot - (double)this.yRot);
            this.yRot = (float)((double)this.yRot + d3 / (double)this.lerpSteps);
            this.xRot = (float)((double)this.xRot + (this.lerpXRot - (double)this.xRot) / (double)this.lerpSteps);
            --this.lerpSteps;
            this.setPos(d0, d1, d2);
            this.setRot(this.yRot, this.xRot);
        }
    }

    protected boolean canAddPassenger(Entity pPassenger) {
        return this.getPassengers().size() < 2 && !this.isEyeInFluid(FluidTags.WATER);
    }

    @Override
    protected void addPassenger(Entity passenger) {
        super.addPassenger(passenger);
        if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
            this.lerpSteps = 0;
            this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYRot, (float)this.lerpXRot);
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return new SSpawnObjectPacket(this);
    }


    public boolean hurt(DamageSource pSource, float pAmount) {
        return super.hurt(pSource, pAmount);
    }

    public void readAdditionalSaveData(CompoundNBT pCompound) {
        this.entityData.set(DATA_ID_FLAGS, pCompound.getByte("DeloFlags"));
    }

    public void addAdditionalSaveData(CompoundNBT pCompound) {
        pCompound.putByte("DeloFlags", this.entityData.get(DATA_ID_FLAGS));
    }


}*/
