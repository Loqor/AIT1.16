package com.mdt.ait.common.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import com.mdt.ait.core.init.AITEntities;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.BreakBlockGoal;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.GroundPathHelper;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;

public class CyberCavalryEntity extends MonsterEntity {
    private static final DataParameter<Integer> DATA_SPECIAL_TYPE_ID = EntityDataManager.defineId(CyberCavalryEntity.class, DataSerializers.INT);
    private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (p_213697_0_) -> {
        return p_213697_0_ == Difficulty.HARD;
    };

    private final BreakDoorGoal breakDoorGoal = new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE);
    private boolean canBreakDoors;

    public CyberCavalryEntity(EntityType<? extends CyberCavalryEntity> entityEntityType, World world) {
        super(entityEntityType, world);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new CyberCavalryEntity.AttackTurtleEggGoal(this, 1.0D, 3));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.addBehaviourGoals();
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        ServerWorld world = Objects.requireNonNull(this.getServer()).getLevel(this.level.dimension());
        Entity cyberman = new CyberCavalryEntity(AITEntities.CYBERCAVALRY.get(), world);
        if(pEntity instanceof AbstractVillagerEntity || pEntity instanceof ZombieEntity) {
            assert world != null;
            world.addFreshEntity(cyberman);
            pEntity.kill();
            cyberman.moveTo(pEntity.getX(), pEntity.getY(), pEntity.getZ());
        }
        return super.doHurtTarget(pEntity);
    }

    @Override
    public AttributeModifierManager getAttributes() {
        return new AttributeModifierManager(createAttributes().build());
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new CybermanAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ClassicDalekEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, K9Entity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_ON_LAND_SELECTOR));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(DATA_SPECIAL_TYPE_ID, 0);
    }

    public boolean canBreakDoors() {
        return this.canBreakDoors;
    }

    public void setCanBreakDoors(boolean pCanBreakDoors) {
        if (this.supportsBreakDoorGoal() && GroundPathHelper.hasGroundPathNavigation(this)) {
            if (this.canBreakDoors != pCanBreakDoors) {
                this.canBreakDoors = pCanBreakDoors;
                ((GroundPathNavigator)this.getNavigation()).setCanOpenDoors(pCanBreakDoors);
                if (pCanBreakDoors) {
                    this.goalSelector.addGoal(1, this.breakDoorGoal);
                } else {
                    this.goalSelector.removeGoal(this.breakDoorGoal);
                }
            }
        } else if (this.canBreakDoors) {
            this.goalSelector.removeGoal(this.breakDoorGoal);
            this.canBreakDoors = false;
        }
    }

    protected boolean supportsBreakDoorGoal() {
        return true;
    }

    protected int getExperienceReward(PlayerEntity pPlayer) {
        this.xpReward = (int)((float)this.xpReward * 2.5F);
        return super.getExperienceReward(pPlayer);
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    protected SoundEvent getAmbientSound() {
        if(this.isAggressive()) {
            return AITSounds.CYBER_YWBD.get();
        } else {
            return null;
        }
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        if (!super.hurt(pSource, pAmount)) {
            return false;
        } else if (!(this.level instanceof ServerWorld)) {
            return false;
        } else {
            this.getHurtSound(pSource);
        return false;
        }
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    protected SoundEvent getStepSound() {
        return AITSounds.CYBER_MARCH_QUICK.get();
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public CreatureAttribute getMobType() {
        return CreatureAttribute.UNDEFINED;
    }
    protected void populateDefaultEquipmentSlots(DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pDifficulty);
        this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(AITItems.CYBER_SHOCK.get()));
    }

    public void addAdditionalSaveData(CompoundNBT pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("CanBreakDoors", this.canBreakDoors());
    }

    public void readAdditionalSaveData(CompoundNBT pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setCanBreakDoors(pCompound.getBoolean("CanBreakDoors"));

    }

    public boolean canHoldItem(ItemStack pStack) {
        return (pStack.getItem() != Items.EGG || !this.isPassenger()) && super.canHoldItem(pStack);
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld pLevel, DifficultyInstance pDifficulty, SpawnReason pReason, @Nullable ILivingEntityData pSpawnData, @Nullable CompoundNBT pDataTag) {
        pSpawnData = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        float f = pDifficulty.getSpecialMultiplier();
        this.setCanPickUpLoot(this.random.nextFloat() < 0.55F * f);

        if (this.getItemBySlot(EquipmentSlotType.HEAD).isEmpty()) {
            LocalDate localdate = LocalDate.now();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 10 && i == 31 && this.random.nextFloat() < 0.25F) {
                this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.armorDropChances[EquipmentSlotType.HEAD.getIndex()] = 0.0F;
            }
        }

        this.handleAttributes(f);
        return pSpawnData;
    }

    protected void handleAttributes(float pDifficulty) {
        this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addPermanentModifier(new AttributeModifier("Random spawn bonus", this.random.nextDouble() * (double)0.05F, AttributeModifier.Operation.ADDITION));
        double d0 = this.random.nextDouble() * 1.5D * (double)pDifficulty;
        if (d0 > 1.0D) {
            this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(new AttributeModifier("Random zombie-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        if (this.random.nextFloat() < pDifficulty * 0.05F) {
            this.setCanBreakDoors(this.supportsBreakDoorGoal());
        }

    }

    public double getMyRidingOffset() {
        return 0.0D;
    }

    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        Entity entity = pSource.getEntity();
        if (entity instanceof CreeperEntity) {
            CreeperEntity creeperentity = (CreeperEntity)entity;
            if (creeperentity.canDropMobsSkull()) {
                ItemStack itemstack = new ItemStack(AITItems.CYBER_SHOCK.get());
                if (!itemstack.isEmpty()) {
                    creeperentity.increaseDroppedSkulls();
                    this.spawnAtLocation(itemstack);
                }
            }
        }
    }

    class AttackTurtleEggGoal extends BreakBlockGoal {
        AttackTurtleEggGoal(CreatureEntity pMob, double pSpeedModifier, int pVerticalSearchRange) {
            super(Blocks.TURTLE_EGG, pMob, pSpeedModifier, pVerticalSearchRange);
        }
        public void playDestroyProgressSound(IWorld pLevel, BlockPos pPos) {
            pLevel.playSound((PlayerEntity)null, pPos, SoundEvents.ZOMBIE_DESTROY_EGG, SoundCategory.HOSTILE, 0.5F, 0.9F + CyberCavalryEntity.this.random.nextFloat() * 0.2F);
        }
        public void playBreakSound(World pLevel, BlockPos pPos) {
            pLevel.playSound((PlayerEntity)null, pPos, SoundEvents.TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F, 0.9F + pLevel.random.nextFloat() * 0.2F);
        }
        public double acceptedDistance() {
            return 1.14D;
        }
    }
}
