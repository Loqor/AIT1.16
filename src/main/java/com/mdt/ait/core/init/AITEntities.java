package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.FallingTardisEntity;
import com.mdt.ait.common.entities.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AITEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, AIT.MOD_ID);

    public static final RegistryObject<EntityType<K9Entity>> K9 = ENTITIES.register(
            "k9_entity", () -> EntityType.Builder.of(K9Entity::new, EntityClassification.CREATURE).sized(1f, 1f).build(
                    new ResourceLocation(AIT.MOD_ID, "k9").toString()));
    public static final RegistryObject<EntityType<CyberCavalryEntity>> CYBERCAVALRY = ENTITIES.register(
            "cyber_cavalry", () -> EntityType.Builder.of(CyberCavalryEntity::new, EntityClassification.MONSTER).sized(0.8f, 2f).build(
                    new ResourceLocation(AIT.MOD_ID, "cyber_cavalry").toString()));
    public static final RegistryObject<EntityType<AngelEntity>> ANGEL_ENTITY = ENTITIES.register(
            "angel_entity", () -> EntityType.Builder.of(AngelEntity::new, EntityClassification.MISC).sized(0.6f, 1.8f).build(
                    new ResourceLocation(AIT.MOD_ID, "angel_entity").toString()));
    public static final RegistryObject<EntityType<ClassicDalekEntity>> CLASSIC_DALEK_ENTITY = ENTITIES.register(
            "classic_dalek", () -> EntityType.Builder.of(ClassicDalekEntity::new, EntityClassification.MONSTER).sized(0.85f, 2f).build(
                    new ResourceLocation(AIT.MOD_ID, "classic_dalek").toString()));
    public static final RegistryObject<EntityType<LaserShotEntity>> LASER_SHOT_ENTITY = ENTITIES.register(
            "laser_shot", () -> EntityType.Builder.of(LaserShotEntity::new, EntityClassification.AMBIENT).sized(0.125f, 0.125f).build(
                    new ResourceLocation(AIT.MOD_ID, "laser_shot").toString()));
    public static final RegistryObject<EntityType<DeloreanEntity>> DELOREAN = ENTITIES.register(
            "delorean", () -> EntityType.Builder.of(DeloreanEntity::new, EntityClassification.MISC).sized(2.5f, 1.5f).build(
                    new ResourceLocation(AIT.MOD_ID, "delorean").toString()));

    //Control Interaction entities
    public static final RegistryObject<EntityType<ControlInteractionEntity>> THROTTLE_INTERACTION_ENTITY = ENTITIES.register(
            "throttle_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(0.1875f, 0.1875f).build(
                    new ResourceLocation(AIT.MOD_ID, "control_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> COORDX_INTERACTION_ENTITY = ENTITIES.register(
            "coordx_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(0.1875f, 0.1875f).build(
                            new ResourceLocation(AIT.MOD_ID, "coordx_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> COORDY_INTERACTION_ENTITY = ENTITIES.register(
            "coordy_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(0.1875f, 0.1875f).build(
                            new ResourceLocation(AIT.MOD_ID, "coordy_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> COORDZ_INTERACTION_ENTITY = ENTITIES.register(
            "coordz_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(0.1875f, 0.1875f).build(
                            new ResourceLocation(AIT.MOD_ID, "coordz_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> INCREMENT_INTERACTION_ENTITY = ENTITIES.register(
            "increment_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(0.1875f, 0.1875f).build(
                            new ResourceLocation(AIT.MOD_ID, "increment_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> DIMENSIONAL_CONTROL_INTERACTION_ENTITY = ENTITIES.register(
            "dimensional_control_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(ControlInteractionEntity.xSize(), ControlInteractionEntity.ySize()).build(
                            new ResourceLocation(AIT.MOD_ID, "dimensional_control_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> POSITIVE_NEGATIVE_INTERACTION_ENTITY = ENTITIES.register(
            "positive_negative_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(ControlInteractionEntity.xSize(), ControlInteractionEntity.ySize()).build(
                            new ResourceLocation(AIT.MOD_ID, "positive_negative_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> EXTERIOR_FACING_INTERACTION_ENTITY = ENTITIES.register(
            "exterior_facing_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(ControlInteractionEntity.xSize(), ControlInteractionEntity.ySize()).build(
                            new ResourceLocation(AIT.MOD_ID, "exterior_facing_interaction_entity").toString()));
    public static final RegistryObject<EntityType<ControlInteractionEntity>> MONITOR_INTERACTION_ENTITY = ENTITIES.register(
            "monitor_interaction_entity", () -> EntityType.Builder.of(ControlInteractionEntity::new, EntityClassification.AMBIENT)
                    .sized(0.5f, 0.5f).build(
                            new ResourceLocation(AIT.MOD_ID, "monitor_interaction_entity").toString()));

    //Falling TARDIS
    public static final RegistryObject<EntityType<FallingTardisEntity>> FALLING_TARDIS_ENTITY = ENTITIES.register(
            "falling_tardis_entity", () -> EntityType.Builder.of(FallingTardisEntity::new, EntityClassification.AMBIENT).sized(0.125f, 0.125f).build(
                    new ResourceLocation(AIT.MOD_ID, "falling_tardis_entity").toString()));
    /*public static final RegistryObject<EntityType<CustomPortalEntity>> CUSTOM_PORTAL_ENTITY = ENTITIES.register(
            "custom_portal_entity", () -> EntityType.Builder.of(CustomPortalEntity::new,EntityClassification.MISC).build(
                    new ResourceLocation(AIT.MOD_ID, "custom_portal_entity").toString()));*/
}