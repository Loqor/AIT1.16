package com.mdt.ait.core.init.events;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.interfaces.ICantBreak;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class CommonEventHandler {

    @SubscribeEvent
    public void onPlayerMine(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() instanceof ICantBreak) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) { // When world loads
        if (!event.getWorld().isClientSide()) { // Server Side Only
            ServerWorld world = (ServerWorld) event.getWorld();
            assert world != null;
            if (world.dimension().equals(ServerWorld.OVERWORLD)) {

                AIT.server = ServerLifecycleHooks.getCurrentServer();
                AIT.dimensionSavedDataManager = AIT.server.overworld().getDataStorage();
            }
        }

    }


}
