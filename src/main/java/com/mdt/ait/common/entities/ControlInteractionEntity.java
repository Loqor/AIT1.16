package com.mdt.ait.common.entities;

import com.mdt.ait.AIT;
import com.mdt.ait.client.screen.MonitorScreen;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.enums.EnumDimensionControlState;
import com.mdt.ait.core.init.enums.EnumExteriorFacingState;
import com.mdt.ait.core.init.enums.EnumLeverState;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.special.DematTransit;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Monitor;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class ControlInteractionEntity extends AmbientEntity {
    private static final DataParameter<Byte> DATA_ID_FLAGS = EntityDataManager.defineId(BatEntity.class, DataSerializers.BYTE);

    public static final String Throttle = "throttle";
    public static final String coordinateX = "x";
    public static final String coordinateY = "y";
    public static final String coordinateZ = "z";
    public static final String Increment = "increment";
    public static final String DimensionalControl = "dimensional_control";
    public static final String posNeg = "positive_negative";
    public static final String exteriorFacing = "exterior_facing";
    public static float sizing = 0.125f;
    public static boolean hasBeenHit = false;
    public UUID tardisID;
    public DematTransit dematTransit;
    private RegistryKey<World> newDimension;
    public EnumDimensionControlState currentdimensionstate = EnumDimensionControlState.EARTH;
    public EnumExteriorFacingState currentExteriorFacingSetting = EnumExteriorFacingState.NORTH;
    public Direction newFacingDirection;

    public void setControlName(String newControlName) {
        this.setCustomName(ITextComponent.nullToEmpty(newControlName));
    }

    public void removeMe() {
        this.remove();
    }

    public void setHasBeenHit() {
        this.hasBeenHit = true;
    }

    public void setHasBeenHitOppo() {
        this.hasBeenHit = false;
    }

    public void setControlTag(String newControlTag, UUID tardisID) {
        this.addTag(newControlTag);
        this.tardisID = tardisID;
    }

    public ControlInteractionEntity(EntityType<? extends AmbientEntity> p_i50290_1_, World p_i50290_2_) {
        super(p_i50290_1_, p_i50290_2_);
    }

    public static float xSize() {
        return ControlInteractionEntity.sizing;
    }

    public static float ySize() {
        return ControlInteractionEntity.sizing;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_FLAGS, (byte)0);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0F;
    }

    /**
     * Gets the pitch of living sounds in living entities.
     */
    protected float getVoicePitch() {
        return 0;
    }

    @Nullable
    public SoundEvent getAmbientSound() {
        return null;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return null;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BAT_DEATH;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean isPushable() {
        return false;
    }

    protected void doPush(Entity pEntity) {
    }

    protected void pushEntities() {
    }

    @Override
    public AttributeModifierManager getAttributes() {
        return new AttributeModifierManager(createAttributes().build());
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D);
    }

    public void changeDimensionFromControl() {
        if(currentdimensionstate == EnumDimensionControlState.EARTH) {
            newDimension = World.OVERWORLD;
        }
        if(currentdimensionstate == EnumDimensionControlState.NETHER) {
            newDimension = World.NETHER;
        }
        if(currentdimensionstate == EnumDimensionControlState.END) {
            newDimension = World.END;
        }
        if(currentdimensionstate == EnumDimensionControlState.GALLIFREY) {
            newDimension = AITDimensions.GALLIFREY;
        }
        if(currentdimensionstate == EnumDimensionControlState.MONDAS) {
            newDimension = AITDimensions.MONDAS;
        }
        if (tardisID != null) {
            AIT.tardisManager.setTargetDimensionForTardis(tardisID, newDimension);
        }

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

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            if (this.tardisID != null) {
                Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                if (tardis.landed != false) {
                    newDimension = tardis.exterior_dimension;
                    if (tardis.exterior_dimension == AIT.server.overworld().dimension()) {
                        currentdimensionstate = EnumDimensionControlState.EARTH;
                    }
                    if (tardis.exterior_dimension == AIT.server.getLevel(World.NETHER).dimension()) {
                        currentdimensionstate = EnumDimensionControlState.NETHER;
                    }
                    if (tardis.exterior_dimension == AIT.server.getLevel(World.END).dimension()) {
                        currentdimensionstate = EnumDimensionControlState.END;
                    }
                    if (tardis.exterior_dimension == AIT.server.getLevel(AITDimensions.GALLIFREY).dimension()) {
                        currentdimensionstate = EnumDimensionControlState.GALLIFREY;
                    }
                    if (tardis.exterior_dimension == AIT.server.getLevel(AITDimensions.MONDAS).dimension()) {
                        currentdimensionstate = EnumDimensionControlState.MONDAS;
                    }
                }
            }
        }
        if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            if (this.tardisID != null) {
                Tardis tardis = AIT.tardisManager.getTardis(tardisID);
                if (tardis.landed != false) {
                    newFacingDirection = tardis.exterior_facing;
                    //currentExteriorFacingSetting = exteriorFacingSetting();
                }
            }
        }
        super.tick();
        this.setDeltaMovement(Vector3d.ZERO);
        this.setPosRaw(this.getX(), this.getY(), this.getZ());
        this.setNoAi(true);
        System.out.println(this.hasBeenHit);
    }

    @Override
    protected ActionResultType mobInteract(PlayerEntity pPlayer, Hand pHand) {
        ItemStack item = pPlayer.getMainHandItem();
        if(pHand == Hand.MAIN_HAND && item.getItem() == AITItems.TENNANT_SONIC.get()) {
            this.remove();
        }
        doInteractionStuff(pPlayer);
        return super.mobInteract(pPlayer, pHand);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.above();
        boolean flag = this.isSilent();
    }

    protected boolean isMovementNoisy() {
        return false;
    }

    public boolean causeFallDamage(float pFallDistance, float pDamageMultiplier) {
        return false;
    }

    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    public EnumDimensionControlState currentDimensionState() {
        return currentdimensionstate;
    }

    public EnumDimensionControlState getNextDimensionState() {
        switch(currentdimensionstate) {
            case EARTH:
                return EnumDimensionControlState.NETHER;
            case NETHER:
                return EnumDimensionControlState.END;
            case END:
                return EnumDimensionControlState.GALLIFREY;
            case GALLIFREY:
                return EnumDimensionControlState.MONDAS;
            case MONDAS:
                return EnumDimensionControlState.EARTH;
        }
        return EnumDimensionControlState.EARTH;
    }

    /**
     * Called when the entity is attacked.
     */
    public void doInteractionStuff(PlayerEntity pSource) {
        boolean randomBool = false;
        if(!this.hasBeenHit && !randomBool) {
            this.setHasBeenHit();
            randomBool = true;
        }
        if(randomBool) {
            this.setHasBeenHitOppo();
            randomBool = false;
        }
        BlockPos blockPos = new BlockPos(this.getX(), this.getY(), this.getZ());
        //Tardis tardis = AIT.tardisManager.getTardis(tardisID);
        //ServerWorld world = AIT.server.getLevel(tardis.exterior_dimension);
        //ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        //assert world != null;
        //assert tardisWorld != null;
        /*if(this.getName() == ITextComponent.nullToEmpty("Throttle") && this.tardisID != null) {
            if (AIT.tardisManager.doesTardisHaveATargetLocation(this.tardisID)) {
                tardisWorld.playSound(null, tardis.center_position, AITSounds.TARDIS_TAKEOFF.get(), SoundCategory.MASTER, 7, 1);
                this.dematTransit = AIT.tardisManager.moveTardisToTargetLocation(tardisID);
                if(this.dematTransit.leverControl != this) {
                    this.dematTransit.leverControl = this;
                }
            }
        }*/
        //System.out.println(this.tardisID + " || " + this.getCustomName().getContents());
        Entity entity = pSource.getEntity();
        if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            this.currentdimensionstate = getNextDimensionState();
            this.playSound(AITSounds.BUTTON_PRESS.get(), 5, 1);
            if(entity instanceof PlayerEntity) {
                ((PlayerEntity) entity).displayClientMessage(new TranslationTextComponent(
                        currentdimensionstate.name()).setStyle(Style.EMPTY.withColor(TextFormatting.WHITE).withBold(true)), true);;
            }
            changeDimensionFromControl();
        }
        if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            this.currentExteriorFacingSetting = getNextExteriorFacingSetting();
            this.playSound(AITSounds.BUTTON_PRESS.get(), 5, 1);
            if(entity instanceof PlayerEntity) {
                ((PlayerEntity) entity).displayClientMessage(new TranslationTextComponent(
                        currentExteriorFacingSetting.name()).setStyle(Style.EMPTY.withColor(TextFormatting.WHITE).withBold(true)), true);;
            }
            changeDirectionFromControl();
        }
        if(this.getCustomName().getContents().equals("Monitor") && this.tardisID != null) {
            Minecraft.getInstance().setScreen(new MonitorScreen(new TranslationTextComponent("TARDIS Monitor"), this.tardisID, pSource.getCommandSenderWorld()));
        }
        if(!this.hurtMarked) {
            this.hurtMarked = true;
        } else {
            this.hurtMarked = false;
        }
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        Entity entity = pSource.getEntity();
        PlayerEntity playerEntity = (PlayerEntity) entity;
        if(playerEntity != null) {
            if (this.isInvulnerableTo(pSource)) {
                return false;
            } else {
                doInteractionStuff(playerEntity);
            }
        }
        return super.hurt(pSource, 0);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(CompoundNBT pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(DATA_ID_FLAGS, pCompound.getByte("ControlFlags"));
        this.hasBeenHit = pCompound.getBoolean("hasbeenhit");
        if (this.tardisID != null) {
            this.tardisID = pCompound.getUUID("tardisID");
        }
        if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            this.currentdimensionstate = EnumDimensionControlState.values()[pCompound.getInt("currentdimensionstate")];
        }
        if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            this.currentExteriorFacingSetting = EnumExteriorFacingState.values()[pCompound.getInt("exteriorfacing")];
        }
    }

    public void addAdditionalSaveData(CompoundNBT pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putByte("ControlFlags", this.entityData.get(DATA_ID_FLAGS));
        pCompound.putBoolean("hasbeenhit", this.hasBeenHit);
        if (this.tardisID != null) {
            pCompound.putUUID("tardisID", this.tardisID);
        }
        if(this.getCustomName().getContents().equals("Dimension Switch") && this.tardisID != null) {
            pCompound.putInt("currentdimensionstate", this.currentdimensionstate.ordinal());
        }
        if(this.getCustomName().getContents().equals("Exterior Facing") && this.tardisID != null) {
            pCompound.putInt("exteriorfacing", this.currentExteriorFacingSetting.ordinal());
        }
    }

    protected float getStandingEyeHeight(Pose pPose, EntitySize pSize) {
        return pSize.height / 2.0F;
    }


}
