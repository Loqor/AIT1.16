package com.mdt.ait.client;


import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.models.exteriors.CoralExterior;
import com.mdt.ait.client.models.exteriors.MintExterior;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.client.renderers.tardis.BasicBoxRenderer;
import com.mdt.ait.client.renderers.tileentities.BasicInteriorDoorRenderer;
import com.mdt.ait.client.renderers.tileentities.RampRenderer;
import com.mdt.ait.client.renderers.tileentities.TSVRenderer;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.AITTiles;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.EnumMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = AIT.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AITClientRegistry {
    public static final EnumMap<EnumExteriorType, Supplier<EntityModel<Entity>>> TARDIS_EXTERIOR_MAP = new EnumMap<>(EnumExteriorType.class);

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE_SLAB.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_MINT_A.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_MINT_B.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TBAKER_ROUNDEL_A.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TBAKER_ROUNDEL_B.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.MASTER_ROUNDEL_A.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.MASTER_ROUNDEL_B.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_BLOWUP_A.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_BLOWUP_B.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_WALL_BLOCK.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_ROUNDEL.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHT.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHT1.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHTA.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHT1A.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TBAKER_SOLID.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.MASTER_SOLID.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.MINT_SOLID.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_BLOWUP_SOLID.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE_BLOCK.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE_BLOCK_SLAB.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.BRASS_PILLAR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(AITBlocks.MINT_SOLID_SLAB.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.ORMULUCLOCK.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(AITBlocks.ARMILLARYSPHERE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(AITBlocks.WAR_ROUNDEL_A.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.WAR_ROUNDEL_B.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.WAR_SOLID.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.WAR_SOLID_SLAB.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.THREE_DOCTORS_ROUNDEL_A.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.THREE_DOCTORS_ROUNDEL_B.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.SMALL_CORAL_ROUNDEL.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_WALL_BLOCK_STRIP.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_WALL_BLOCK_STRIP_ONE.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TEST_BLOCK.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_ORANGE.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_BLUE.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_PURPLE.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_GREEN.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_ROOF.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_ROOF_LIGHT.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_PILLAR.get(), RenderType.solid());
            RenderTypeLookup.setRenderLayer(AITBlocks.INVIS_BLOCK.get(), RenderType.translucent());
        });
        ClientRegistry.bindTileEntityRenderer(AITTiles.TARDIS_TILE_ENTITY_TYPE.get(), BasicBoxRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TSV_TILE_ENTITY_TYPE.get(), TSVRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.BASIC_INTERIOR_DOOR_TILE_ENTITY_TYPE.get(), BasicInteriorDoorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.RAMP_TILE_ENTITY_TYPE.get(), RampRenderer::new);

        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.BASIC_BOX, BasicBox::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.MINT_BOX, MintExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.CORAL_BOX, CoralExterior::new);
    }

}
