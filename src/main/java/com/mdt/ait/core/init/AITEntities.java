package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import com.mdt.ait.common.entities.AngelEntity;
import com.mdt.ait.common.entities.CyberCavalryEntity;
import com.mdt.ait.common.entities.K9Entity;
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
            "cybercavalry", () -> EntityType.Builder.of(CyberCavalryEntity::new, EntityClassification.CREATURE).sized(1f, 2f).build(
                    new ResourceLocation(AIT.MOD_ID, "cybercavalry").toString()));
    public static final RegistryObject<EntityType<AngelEntity>> ANGEL_ENTITY = ENTITIES.register(
            "angelentity", () -> EntityType.Builder.of(AngelEntity::new, EntityClassification.MISC).sized(1f, 2f).build(
                    new ResourceLocation(AIT.MOD_ID, "angelentity").toString()));
}