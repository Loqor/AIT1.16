package com.mdt.ait.core.init.events;

import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.interfaces.ICantBreak;
import com.mdt.ait.helpers.tardis.TardisManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class CommonEventHandler {

    @SubscribeEvent
    public void onPlayerMine(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() instanceof ICantBreak) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent //I'd be inclined to move this into a specified block item class for tardises
    public void onPlace(BlockEvent.EntityPlaceEvent event) {
        Entity placing_entity = event.getEntity();
        IWorld placed_in_world = event.getWorld();
        RegistryKey key = placing_entity.level.dimension();
        BlockPos bpos = event.getPos();
        if (placing_entity != null && placed_in_world != null && event.getPlacedBlock().getBlock() instanceof TardisBlock) {
            TardisManager tardis_manager = TardisManager.getTardisManagerForWorld(placing_entity.level);
            UUID tardis_id = placing_entity.getUUID();
            //cancel if a tardis by that name is already registered
            if (tardis_manager.hasTardis(tardis_id)) {
                event.setCanceled(true);
                PlayerEntity p = (PlayerEntity) placing_entity;

                placing_entity.sendMessage(new TranslationTextComponent("You already have a TARDIS!"), UUID.randomUUID());
                return;
            }
            TileEntity potiential_tile_entity = placed_in_world.getBlockEntity(event.getPos());
            if (potiential_tile_entity instanceof TardisTileEntity) {
                ((TardisTileEntity) potiential_tile_entity).linked_tardis = tardis_manager.newTardis(tardis_id, event.getPos(), placed_in_world.isClientSide());
                ((TardisTileEntity) potiential_tile_entity).linked_tardis_id = tardis_id;
            }
        }
    }
}
