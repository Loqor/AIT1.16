package com.mdt.ait.common.blocks;

import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.AITEntities;
import com.mdt.ait.core.init.AITItems;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

import java.util.UUID;

public class FallingTardisEntity extends Entity {

    public EnumExteriorType currentexterior = EnumExteriorType.BASIC_BOX;
    private static final DataParameter<Byte> DATA_ID_FLAGS = EntityDataManager.defineId(FallingTardisEntity.class, DataSerializers.BYTE);
    public BlockState blockState = AITBlocks.TARDIS_BLOCK.get().defaultBlockState();
    public UUID tardisID;
    public TardisTileEntity tardisTileEntity;

    public FallingTardisEntity(EntityType<? extends Entity> entityEntityType, World world) {
        super(entityEntityType, world);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_ID_FLAGS, (byte)0);
    }

    public EnumExteriorType getNextExterior() {
        switch (currentexterior) {
            case BASIC_BOX:
                return EnumExteriorType.MINT_BOX;
            case MINT_BOX:
                return EnumExteriorType.CORAL_BOX;
            case CORAL_BOX:
                return EnumExteriorType.POSTER_BOX;
            case POSTER_BOX:
                return EnumExteriorType.BAKER_BOX;
            case BAKER_BOX:
                return EnumExteriorType.TYPE_40_TT_CAPSULE;
            case TYPE_40_TT_CAPSULE:
                return EnumExteriorType.HELLBENT_TT_CAPSULE;
            case HELLBENT_TT_CAPSULE:
                return EnumExteriorType.NUKA_COLA_EXTERIOR;
            case NUKA_COLA_EXTERIOR:
                return EnumExteriorType.ARCADE_CABINET_EXTERIOR;
            case SIEGE_MODE:
                return EnumExteriorType.BASIC_BOX;
            case ARCADE_CABINET_EXTERIOR:
                return EnumExteriorType.CUSHING_EXTERIOR;
            case CUSHING_EXTERIOR:
                return EnumExteriorType.CLASSIC_EXTERIOR;
            case CLASSIC_EXTERIOR:
                return EnumExteriorType.HARTNELL_EXTERIOR;
            case HARTNELL_EXTERIOR:
                return EnumExteriorType.HUDOLIN_EXTERIOR;
            case HUDOLIN_EXTERIOR:
                return EnumExteriorType.TX3_EXTERIOR;
            case TX3_EXTERIOR:
                return EnumExteriorType.TARDIM_EXTERIOR;
            case TARDIM_EXTERIOR:
                return EnumExteriorType.SHALKA_EXTERIOR;
            case SHALKA_EXTERIOR:
                return EnumExteriorType.BOOTH_EXTERIOR;
            case BOOTH_EXTERIOR:
                return EnumExteriorType.STEVE_EXTERIOR;
            case STEVE_EXTERIOR:
                return EnumExteriorType.FALLOUT_SHELTER_EXTERIOR;
            case FALLOUT_SHELTER_EXTERIOR:
                return EnumExteriorType.RANI_EXTERIOR;
            case RANI_EXTERIOR:
                return EnumExteriorType.BASIC_BOX;
        }
        return EnumExteriorType.BASIC_BOX;
    }

    public EnumExteriorType getCurrentExterior() {
        return currentexterior;
    }

    public EnumExteriorType getLastExterior() {
        switch (currentexterior) {
            case BASIC_BOX:
                return EnumExteriorType.RANI_EXTERIOR;
            case MINT_BOX:
                return EnumExteriorType.BASIC_BOX;
            case CORAL_BOX:
                return EnumExteriorType.MINT_BOX;
            case POSTER_BOX:
                return EnumExteriorType.CORAL_BOX;
            case BAKER_BOX:
                return EnumExteriorType.POSTER_BOX;
            case TYPE_40_TT_CAPSULE:
                return EnumExteriorType.BAKER_BOX;
            case HELLBENT_TT_CAPSULE:
                return EnumExteriorType.TYPE_40_TT_CAPSULE;
            case NUKA_COLA_EXTERIOR:
                return EnumExteriorType.HELLBENT_TT_CAPSULE;
            case SIEGE_MODE:
                return EnumExteriorType.SIEGE_MODE;
            case ARCADE_CABINET_EXTERIOR:
                return EnumExteriorType.NUKA_COLA_EXTERIOR;
            case CUSHING_EXTERIOR:
                return EnumExteriorType.ARCADE_CABINET_EXTERIOR;
            case CLASSIC_EXTERIOR:
                return EnumExteriorType.CUSHING_EXTERIOR;
            case HARTNELL_EXTERIOR:
                return EnumExteriorType.CLASSIC_EXTERIOR;
            case HUDOLIN_EXTERIOR:
                return EnumExteriorType.HARTNELL_EXTERIOR;
            case TX3_EXTERIOR:
                return EnumExteriorType.HUDOLIN_EXTERIOR;
            case TARDIM_EXTERIOR:
                return EnumExteriorType.TX3_EXTERIOR;
            case SHALKA_EXTERIOR:
                return EnumExteriorType.TARDIM_EXTERIOR;
            case BOOTH_EXTERIOR:
                return EnumExteriorType.SHALKA_EXTERIOR;
            case STEVE_EXTERIOR:
                return EnumExteriorType.BOOTH_EXTERIOR;
            case FALLOUT_SHELTER_EXTERIOR:
                return EnumExteriorType.STEVE_EXTERIOR;
            case RANI_EXTERIOR:
                return EnumExteriorType.FALLOUT_SHELTER_EXTERIOR;
        }
        return EnumExteriorType.BASIC_BOX;
    }

    @Override
    public ActionResultType interact(PlayerEntity pPlayer, Hand pHand) {
        if(pPlayer.isCrouching() && pPlayer.getItemInHand(Hand.MAIN_HAND).getItem() == AITItems.TENNANT_SONIC.get()) {
            currentexterior = getNextExterior();
        }
        return super.interact(pPlayer, pHand);
    }

    @Override
    public void tick() {
        super.tick();
        BlockPos blockPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        if(!this.level.isEmptyBlock(blockPos)) {
            this.level.setBlockAndUpdate(blockPos, blockState);
            this.level.setBlockEntity(blockPos, this.tardisTileEntity);
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return null;
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        this.entityData.set(DATA_ID_FLAGS, nbt.getByte("ControlFlags"));
        if(this.tardisID != null) {
            this.tardisID = nbt.getUUID("tardisID");
        }
        this.currentexterior = EnumExteriorType.values()[nbt.getInt("currentexterior")];
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        nbt.putByte("ControlFlags", this.entityData.get(DATA_ID_FLAGS));
        if(this.tardisID != null) {
            nbt.putUUID("tardisID", this.tardisID);
        }
        nbt.putInt("currentexterior", this.currentexterior.ordinal());
    }
}
