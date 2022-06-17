package com.mdt.ait;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdt.ait.core.init.*;
import com.mdt.ait.core.init.events.CommonEventHandler;
import com.mdt.ait.helpers.DynamicDimensionHelper;
import com.mdt.ait.helpers.tardis.TardisManager;
import com.mdt.ait.network.Network;
import net.minecraft.client.gui.screen.WorldLoadProgressScreen;
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

    public AIT() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //bus.addListener(this::commonSetup);
        //bus.addListener(this::registerEntityAttributes);
        TardisManager.getInstance();
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        AITBlocks.BLOCKS.register(bus);
        AITItems.ITEMS.register(bus);
        AITTiles.TILE_ENTITIES.register(bus);
        AITSounds.SOUNDS.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DynamicDimensionHelper.registerChunkGenerators();
        Network.init();
    }

}
