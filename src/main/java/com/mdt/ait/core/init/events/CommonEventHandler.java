package com.mdt.ait.core.init.events;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.blocks.TardisCoralBlock;
import com.mdt.ait.core.init.interfaces.ICantBreak;
import com.mdt.ait.core.init.interfaces.ITardisBlock;
import com.mojang.brigadier.Message;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SoulSandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.UUID;

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

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getState().getBlock() instanceof TardisCoralBlock) {
            BlockPos blockPos = event.getPos();
            Entity entity = event.getEntity();
            PlayerEntity p = (PlayerEntity)entity;
            BlockState blockState = event.getPlacedBlock();
            Block block = blockState.getBlock();
            BlockPos bPos = new BlockPos(blockPos.getX(), blockPos.getY() -1 , blockPos.getZ());
            BlockPos bPos1 = new BlockPos(blockPos.getX() + 1, blockPos.getY() -1 , blockPos.getZ());
            BlockPos bPos2 = new BlockPos(blockPos.getX() - 1, blockPos.getY() -1 , blockPos.getZ());
            BlockPos bPos3 = new BlockPos(blockPos.getX(), blockPos.getY() -1 , blockPos.getZ() + 1);
            BlockPos bPos4 = new BlockPos(blockPos.getX(), blockPos.getY() -1 , blockPos.getZ() - 1);
            BlockPos bPos5 = new BlockPos(blockPos.getX() + 1, blockPos.getY() -1 , blockPos.getZ() + 1);
            BlockPos bPos6 = new BlockPos(blockPos.getX() + 1, blockPos.getY() -1 , blockPos.getZ() - 1);
            BlockPos bPos7 = new BlockPos(blockPos.getX() - 1, blockPos.getY() -1 , blockPos.getZ() + 1);
            BlockPos bPos8 = new BlockPos(blockPos.getX() - 1, blockPos.getY() -1 , blockPos.getZ() - 1);
            IWorld world = event.getWorld();
            if(world.getBlockState(bPos).getBlock() instanceof SoulSandBlock
                    && (world.getBlockState(bPos1).getBlock() instanceof SoulSandBlock)
                    && (world.getBlockState(bPos2).getBlock() instanceof SoulSandBlock)
                    && (world.getBlockState(bPos3).getBlock() instanceof SoulSandBlock)
                    && (world.getBlockState(bPos4).getBlock() instanceof SoulSandBlock)
                    && (world.getBlockState(bPos5).getBlock() instanceof SoulSandBlock)
                    && (world.getBlockState(bPos6).getBlock() instanceof SoulSandBlock)
                    && (world.getBlockState(bPos7).getBlock() instanceof SoulSandBlock)
                    && (world.getBlockState(bPos8).getBlock() instanceof SoulSandBlock)
                    && world.getLevelData().isRaining()) {
                event.setCanceled(false);
            } else {
                event.setCanceled(true);
                p.sendMessage(new TranslationTextComponent("You can't grow this on here!"), UUID.randomUUID());
            }
        }
    }

}
