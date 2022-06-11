package com.mdt.ait.client;


import com.mdt.ait.AIT;
import com.mdt.ait.client.models.exteriors.BasicBox;
import com.mdt.ait.client.models.exteriors.CoralExterior;
import com.mdt.ait.client.models.exteriors.MintExterior;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.client.renderers.tardis.BasicBoxRenderer;
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
            RenderTypeLookup.setRenderLayer(AITBlocks.TEST_BLOCK.get(), RenderType.solid());
        });
        ClientRegistry.bindTileEntityRenderer(AITTiles.TARDIS_TILE_ENTITY_TYPE.get(), BasicBoxRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TSV_TILE_ENTITY_TYPE.get(), TSVRenderer::new);

        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.BASIC_BOX, BasicBox::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.MINT_BOX, MintExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.CORAL_BOX, CoralExterior::new);
    }

}
