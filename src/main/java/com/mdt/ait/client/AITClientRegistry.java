package com.mdt.ait.client;


import com.mdt.ait.AIT;
import com.mdt.ait.client.models.consoles.BorealisConsole;
import com.mdt.ait.client.models.consoles.DevConsole;
import com.mdt.ait.client.models.consoles.HudolinConsole;
import com.mdt.ait.client.models.exteriors.*;
import com.mdt.ait.client.renderers.AITRenderTypes;
import com.mdt.ait.client.renderers.consoles.BasicConsoleRenderer;
import com.mdt.ait.client.renderers.entity.*;
import com.mdt.ait.client.renderers.layers.*;
import com.mdt.ait.client.renderers.machines.DeloreanRenderer;
import com.mdt.ait.client.renderers.tardis.BasicBoxRenderer;
import com.mdt.ait.client.renderers.tardis.FallingTardisRenderer;
import com.mdt.ait.client.renderers.tileentities.*;
import com.mdt.ait.common.entities.LaserShotEntity;
import com.mdt.ait.common.tileentities.DimensionSwitchControlTile;
import com.mdt.ait.common.tileentities.TardisLeverTile;
import com.mdt.ait.core.init.AITEntities;
import com.mdt.ait.core.init.enums.EnumConsoleType;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.core.init.AITBlocks;
import com.mdt.ait.core.init.AITTiles;
import com.mdt.ait.core.init.enums.EnumInteriorDoorType;
import com.mdt.ait.tardis.Tardis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = AIT.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AITClientRegistry {
    public static final EnumMap<EnumExteriorType, Supplier<EntityModel<Entity>>> TARDIS_EXTERIOR_MAP = new EnumMap<>(EnumExteriorType.class);
    public static final EnumMap<EnumConsoleType, Supplier<EntityModel<Entity>>> TARDIS_CONSOLE_MAP = new EnumMap<>(EnumConsoleType.class);
    public static final EnumMap<EnumInteriorDoorType, Supplier<EntityModel<Entity>>> TARDIS_DOOR_MAP = new EnumMap<>(EnumInteriorDoorType.class);

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE_SLAB.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_MINT_A.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_MINT_B.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TBAKER_ROUNDEL_A.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TBAKER_ROUNDEL_B.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_BLOWUP_A.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_BLOWUP_B.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_WALL_BLOCK.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_ROUNDEL.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHT.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHT1.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHTA.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_FLASHING_LIGHT1A.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.MINT_SOLID.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.HARTNELL_BLOWUP_SOLID.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE_BLOCK.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.STEEL_GRATE_BLOCK_SLAB.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.BRASS_PILLAR.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.MINT_SOLID_SLAB.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.ORMULUCLOCK.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.COW_SKULL.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.ARMILLARYSPHERE.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.WAR_ROUNDEL_A.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.WAR_ROUNDEL_B.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.THREE_DOCTORS_ROUNDEL_A.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.THREE_DOCTORS_ROUNDEL_B.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.THREE_DOCTORS_SOLID.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.SMALL_CORAL_ROUNDEL.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_WALL_BLOCK_STRIP.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.CORAL_WALL_BLOCK_STRIP_ONE.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TEST_BLOCK.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_ORANGE.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_BLUE.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_PURPLE.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.LIGHT_BLOCK_GREEN.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_ROOF.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_ROOF_LIGHT.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.TOYOTA_PILLAR.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.INVIS_BLOCK.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.RICK_PORTAL_BLOCK.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(AITBlocks.GALLIFREY_STONE.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.GALLIFREY_SAND.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.INTERIOR_CENTER_BLOCK.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.DARKSTONE.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.DARKSTONE_STAIRS.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.ARS_PRODUCER.get(), RenderType.cutoutMipped());
            RenderTypeLookup.setRenderLayer(AITBlocks.ARS_GENERATE_BLOCK.get(), RenderType.cutoutMipped());
        });
        ClientRegistry.bindTileEntityRenderer(AITTiles.TARDIS_TILE_ENTITY_TYPE.get(), BasicBoxRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TSV_TILE_ENTITY_TYPE.get(), TSVRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.BASIC_INTERIOR_DOOR_TILE_ENTITY_TYPE.get(), BasicInteriorDoorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.RAMP_TILE_ENTITY_TYPE.get(), RampRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TYPEWRITER_TILE_ENTITY_TYPE.get(), TypewriterRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.CONSOLE_TILE_ENTITY_TYPE.get(), BasicConsoleRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TARDIS_CORAL_TILE_ENTITY_TYPE.get(), TardisCoralRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TARDIS_LEVER_TILE_ENTITY_TYPE.get(), TardisLeverRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.ROUNDEL_FACE_TILE_ENTITY_TYPE.get(), RoundelFaceRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.GBTCASING_TILE_ENTITY_TYPE.get(), GBTCasingRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.RECORD_PLAYER_TILE_ENTITY_TYPE.get(), RecordPlayerRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.BASIC_ROTOR_TILE_ENTITY_TYPE.get(), BasicRotorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.HUDOLIN_ROTOR_TILE_ENTITY_TYPE.get(), HudolinRotorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TOYOTA_WHIRLAGIG_TILE_ENTITY_TYPE.get(), ToyotaWhirlagigRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TOYOTA_ROTOR_TILE_ENTITY_TYPE.get(), ToyotaRotorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.DIMENSION_SWITCH_CONTROL_TILE_ENTITY_TYPE.get(), DimensionSwitchControlRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TARDIS_COORDINATE_CONTROL_TILE_ENTITY_TYPE.get(), TardisCoordinateControlRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.EXTERIOR_FACING_CONTROL_TILE_ENTITY_TYPE.get(), ExteriorFacingControlRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.HARTNELL_ROTOR_TILE_ENTITY_TYPE.get(), HartnellRotorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TENNANT_MONITOR_TILE_ENTITY_TYPE.get(), TennantMonitorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TOYOTA_MONITOR_TILE_ENTITY_TYPE.get(), ToyotaMonitorRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.TARDIS_POWER_ACCESS_POINT_TILE_ENTITY_TYPE.get(), TardisPowerAccessPointRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.DOOR_SWITCH_CONTROL_TILE_ENTITY_TYPE.get(), DoorSwitchControlRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.ROUNDEL_DOORS_TILE_ENTITY_TYPE.get(), RoundelDoorsRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AITTiles.ARS_EGG_TILE_ENTITY_TYPE.get(), ArsEggRenderer::new);

        //Temporary
        ClientRegistry.bindTileEntityRenderer(AITTiles.VORTEX_TILE_ENTITY_TYPE.get(), VortexRenderer::new);

        //Exterior model registry
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.BASIC_BOX, BasicBox::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.MINT_BOX, MintExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.CORAL_BOX, CoralExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.POSTER_BOX, BasicBox::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.BAKER_BOX, BakerExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.TYPE_40_TT_CAPSULE, Type40TTCapsuleExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.HELLBENT_TT_CAPSULE, HellBentTTCapsuleExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.NUKA_COLA_EXTERIOR, NukaColaExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.SIEGE_MODE, SiegeMode::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.ARCADE_CABINET_EXTERIOR, ArcadeCabinet::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.CUSHING_EXTERIOR, CushingExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.CLASSIC_EXTERIOR, ClassicExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.HARTNELL_EXTERIOR, HartnellExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.HUDOLIN_EXTERIOR, HudolinExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.TX3_EXTERIOR, TxThreeCapsule::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.TARDIM_EXTERIOR, TARDIMExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.SHALKA_EXTERIOR, ShalkaExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.BOOTH_EXTERIOR, BoothExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.STEVE_EXTERIOR, SteveExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.FALLOUT_SHELTER_EXTERIOR, FalloutShelterExterior::new);
        TARDIS_EXTERIOR_MAP.put(EnumExteriorType.CLOCK_EXTERIOR, ClockExterior::new);

        //Interior door model registry
        TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_BASIC_BOX, BasicBox::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_MINT_BOX, MintExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_CORAL_BOX, CoralExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_POSTER_BOX, BasicBox::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_BAKER_BOX, BakerExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_TYPE_40_TT_CAPSULE, Type40TTCapsuleExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_HELLBENT_TT_CAPSULE, HellBentTTCapsuleExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_NUKA_COLA_EXTERIOR, NukaColaExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_SIEGE_MODE, SiegeMode::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_ARCADE_CABINET_EXTERIOR, ArcadeCabinet::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_CUSHING_EXTERIOR, CushingExterior::new);
        TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_CLASSIC_EXTERIOR, ClassicExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_HARTNELL_EXTERIOR, HartnellExterior::new);
        TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_HUDOLIN_EXTERIOR, HudolinExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_TX3_EXTERIOR, TxThreeCapsule::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_TARDIM_EXTERIOR, TARDIMExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_SHALKA_EXTERIOR, ShalkaExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_BOOTH_EXTERIOR, BoothExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_STEVE_EXTERIOR, SteveExterior::new);
        TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_FALLOUT_SHELTER_EXTERIOR, FalloutShelterExterior::new);
        //TARDIS_DOOR_MAP.put(EnumInteriorDoorType.DOOR_CLOCK_EXTERIOR, ClockExterior::new);

        //Console model registry
        TARDIS_CONSOLE_MAP.put(EnumConsoleType.DEV_CONSOLE, DevConsole::new);
        TARDIS_CONSOLE_MAP.put(EnumConsoleType.BOREALIS_CONSOLE, BorealisConsole::new);
        TARDIS_CONSOLE_MAP.put(EnumConsoleType.HUDOLIN_CONSOLE, HudolinConsole::new);

        RenderingRegistry.registerEntityRenderingHandler(AITEntities.K9.get(), K9EntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.CYBERCAVALRY.get(), CyberCavalryRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.ANGEL_ENTITY.get(), AngelEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.CLASSIC_DALEK_ENTITY.get(), ClassicDalekEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.LASER_SHOT_ENTITY.get(), LaserShotEntityRenderer::new);

        //CONTROL ENTITIES
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.THROTTLE_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.COORDX_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.COORDY_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.COORDZ_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.INCREMENT_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.DIMENSIONAL_CONTROL_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.POSITIVE_NEGATIVE_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.EXTERIOR_FACING_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.MONITOR_INTERACTION_ENTITY.get(), ControlInteractionEntityRenderer::new);

        //Falling TARDIS
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.FALLING_TARDIS_ENTITY.get(), FallingTardisRenderer::new);
        //RenderingRegistry.registerEntityRenderingHandler(AITEntities.CUSTOM_PORTAL_ENTITY.get(), CustomPortalRenderer::new);

        //Machinery
        RenderingRegistry.registerEntityRenderingHandler(AITEntities.DELOREAN.get(), DeloreanRenderer::new);

        Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap();
        for (PlayerRenderer renderPlayer : skinMap.values()) {
            renderPlayer.addLayer(new CowSkullModelLayer<>(renderPlayer));
            renderPlayer.addLayer(new FezModelLayer<>(renderPlayer));
            renderPlayer.addLayer(new MessengerBagModelLayer<>(renderPlayer));
            renderPlayer.addLayer(new ThreeDGlassesModelLayer<>(renderPlayer));
            renderPlayer.addLayer(new AngelWingsModelLayer<>(renderPlayer));
            renderPlayer.addLayer(new FourthsScarfModelLayer<>(renderPlayer));
        }
    }

}
