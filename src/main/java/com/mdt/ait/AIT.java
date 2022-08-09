package com.mdt.ait;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdt.ait.core.init.*;
import com.mdt.ait.core.init.events.CommonEventHandler;
import com.mdt.ait.core.init.events.TardisEventHandler;
import com.mdt.ait.depreciated.helpers.DynamicDimensionHelper;
import com.mdt.ait.network.Network;
import com.mdt.ait.tardis.TardisManager;
import net.minecraft.client.gui.screen.WorldLoadProgressScreen;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AIT.MOD_ID)
public class AIT {

    //ADD VEHICLES
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ait";
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static MinecraftServer server;

    public static TardisManager tardisManager;
    public static DimensionSavedDataManager dimensionSavedDataManager;

    public AIT() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //bus.addListener(this::commonSetup);
        //bus.addListener(this::registerEntityAttributes);
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        MinecraftForge.EVENT_BUS.register(new TardisEventHandler()); // OldTardis specific event handler
        AITBlocks.BLOCKS.register(bus);
        AITItems.ITEMS.register(bus);
        AITTiles.TILE_ENTITIES.register(bus);
        AITSounds.SOUNDS.register(bus);



    }

    private void setup(final FMLCommonSetupEvent event) {
        DynamicDimensionHelper.registerChunkGenerators();
        Network.init();
    }

    /*
      DEPRECIATED
      Moved to onWorldLoad in CommonEventHandler and TardisEventHandler
     */
    @Deprecated
    private void worldLoad(final WorldLoadProgressScreen event) {



    }

}
