package com.mdt.ait.core.init.events;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.interfaces.ITardisBlock;
import io.mdt.ait.tardis.TARDIS;
import io.mdt.ait.tardis.TARDISManager;
import io.mdt.ait.tardis.exterior.TARDISExteriors;
import io.mdt.ait.tardis.interior.TARDISInteriors;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TardisEventHandler {

    @SubscribeEvent
    public void onPlayerMine(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() instanceof ITardisBlock) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        /*if (event.getState().getBlock() instanceof ITardisBlock) {
            BlockPos blockPos = event.getPos();
            BlockState blockState = event.getPlacedBlock();
            Block block = blockState.getBlock();

            World world = (World) event.getWorld();
            RegistryKey<World> worldRegistryKey = world.dimension();

            if (event.getEntity() != null) {
                if (!blockState.getValue(TardisBlock.isExistingTardis)) {
                    Entity entity = event.getEntity();
                    Direction entityFacingDirection = entity.getDirection();
                    Direction blockFacingDirection = entityFacingDirection.getOpposite();
                    TARDIS tardis = TARDISManager.create(blockPos, worldRegistryKey);
                    TARDISTileEntity tardisTileEntity = (TARDISTileEntity) world.getBlockEntity(blockPos);
                    tardisTileEntity.link(tardis);
                }
            }
        }*/

        if (event.getState().getBlock() instanceof BasicInteriorDoorBlock) {
            if (!event.getWorld().isClientSide()) {
                ServerWorld serverWorld = (ServerWorld) event.getWorld();
                if (serverWorld.dimension() == AITDimensions.TARDIS_DIMENSION) {
                    TARDIS tardis = TARDISManager.findTARDIS(event.getPos());
                    BlockState blockState = serverWorld.getBlockState(tardis.getDoor().getPosition());
                    Block block = blockState.getBlock();
                    if (block instanceof BasicInteriorDoorBlock) {
                        // @TODO: On destroy will make it so we can place the interior back in the same spot, basically it won't let the player replace the door where it originally was.
                        // @TODO: Add a message for the player to remove the original interior door
                        // @TODO: Make sure to not remove the block from their inventory if it's cancelled
                        event.setCanceled(true); // Event cancelled
                    }
                }
            }
        }
    }

    boolean loaded = false;

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (!event.getWorld().isClientSide()) { // Server Side Only
            /*
            Everything with this if statement will break and stop the world from loading if it isn't made sure to be server side
             */
            ServerWorld world = (ServerWorld) event.getWorld();
            if (world.dimension().equals(ServerWorld.OVERWORLD)) {
                this.loaded = true;
            }

            if (world.dimension().equals(AITDimensions.TARDIS_DIMENSION)) {
                if (this.loaded) {
                    AIT.dimensionSavedDataManager.computeIfAbsent(TARDISManager::getSavedData, "ait"); // DO NOT CHANGE ANYTHING IN THIS LINE OR EVERYTHING BREAKS

                    TARDISExteriors.init();
                    TARDISInteriors.init();
                }
            }
        }
    }


}
