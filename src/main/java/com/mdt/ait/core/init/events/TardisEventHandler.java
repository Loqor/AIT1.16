package com.mdt.ait.core.init.events;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.interfaces.ITardisBlock;
import com.mdt.ait.tardis.Tardis;
import com.mdt.ait.tardis.TardisInteriors;
import com.mdt.ait.tardis.TardisManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TardisEventHandler {

    public static boolean overWorldLoaded = false;

    @SubscribeEvent
    public void onPlayerMine(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() instanceof ITardisBlock) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.EntityPlaceEvent event) throws Exception {
        if (event.getState().getBlock() instanceof ITardisBlock) {

            BlockPos blockPos = event.getPos();
            BlockState blockState = event.getPlacedBlock();
            Block block = blockState.getBlock();

            World world = (World) event.getWorld();
            RegistryKey<World> worldRegistryKey = world.dimension();

            TardisManager tardisManager = AIT.tardisManager;

            if (event.getEntity() != null) {
                AIT.print("Place yes past entity");
                if (!blockState.getValue(TardisBlock.isExistingTardis)) {
                    Entity entity = event.getEntity();
                    assert entity != null;
                    Direction entityFacingDirection = entity.getDirection();
                    Direction blockFacingDirection = entityFacingDirection.getOpposite();
                    Tardis tardis = tardisManager.createNewTardis(entity.getUUID(), blockPos, worldRegistryKey);
                    TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(blockPos);
                    assert tardisTileEntity != null;
                    tardisTileEntity.linked_tardis = tardis;
                    tardisTileEntity.linked_tardis_id = tardis.tardisID;
                }
                }



        }
    }


    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (!event.getWorld().isClientSide()) { // Server Side Only
            /*
            Everything with this if statement will break and stop the world from loading if it isn't made sure to be server side
             */
            ServerWorld world = (ServerWorld) event.getWorld();
            assert world != null;
            if (world.dimension().equals(ServerWorld.OVERWORLD)) {

                AIT.tardisManager = new TardisManager();
                AIT.dimensionSavedDataManager.computeIfAbsent(AIT.tardisManager.getTardisWorldSavedData().getSupplier(), "ait_DATA"); // DO NOT CHANGE ANYTHING IN THIS LINE OR EVERYTHING BREAKS
                overWorldLoaded = true;


            }

            if (world.dimension().equals(AITDimensions.TARDIS_DIMENSION)) {
                if (overWorldLoaded) {
                    TardisInteriors.init();
                }

            }
        }

    }
}
