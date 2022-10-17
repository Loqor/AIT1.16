package com.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
import com.mdt.ait.core.init.enums.EnumDoorState;
import com.mdt.ait.core.init.enums.EnumExteriorType;
import com.mdt.ait.tardis.interiors.TardisInterior;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.hooks.BasicEventHooks;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Tardis implements IEnergyStorage {

    public BlockPos exterior_position;
    public BlockPos interior_door_position;
    public Direction exterior_facing;
    public Direction interior_door_facing;
    public final BlockPos center_position;
    public Boolean landed = false;

    public EnumExteriorType exteriorType;
    public TardisInterior currentInterior;
    public final Tuple<Integer, Integer> grid_position;
    public RegistryKey<World> exterior_dimension;

    public BlockPos console_position;

    public int max_energy_storage;

    public int current_energy;

    public int energy_recharge_rate; // Energy per second
    public final UUID owner;
    public boolean lockedTardis;

    public final UUID tardisID;

    public RegistryKey<World> target_dimension;
    public BlockPos targetPosition;
    public Direction target_facing_direction;

    public Tardis(UUID player, BlockPos exterior_position, RegistryKey<World> exterior_dimension, UUID tardisID, Tuple<Integer, Integer> grid_position, boolean lockedTardis) {
        System.out.println("Creating new tardis");
        this.owner = player;
        this.lockedTardis = lockedTardis;
        this.exterior_dimension = exterior_dimension;
        this.target_dimension = this.exterior_dimension;
        this.exterior_position = exterior_position;
        this.targetPosition = exterior_position;
        this.grid_position = grid_position;
        this.tardisID = tardisID;
        this.currentInterior = TardisInteriors.devInterior;
        this.max_energy_storage = TardisConfig.tardis_default_base_energy_storage;
        this.energy_recharge_rate = TardisConfig.tardis_default_energy_recharge_rate;
        this.current_energy = this.max_energy_storage;
        this.exteriorType = ((TardisTileEntity) Objects.requireNonNull(Objects.requireNonNull(AIT.server.getLevel(exterior_dimension)).getBlockEntity(exterior_position))).currentExterior();
        this.center_position = new BlockPos(TardisConfig.tardis_dimension_start_x-(TardisConfig.tardis_area_x * grid_position.getA()) + ((TardisConfig.tardis_area_x - 1)/2) + 1,TardisConfig.tardis_center_y,TardisConfig.tardis_dimension_start_z-(TardisConfig.tardis_area_z * grid_position.getB()) + ((TardisConfig.tardis_area_z - 1)/2) + 1);
        BlockState exteriorBlockState = Objects.requireNonNull(AIT.server.getLevel(exterior_dimension)).getBlockState(exterior_position);
        if (exteriorBlockState.getBlock() instanceof TardisBlock) {
            this.exterior_facing = exteriorBlockState.getValue(TardisBlock.FACING);
        }
        this.target_facing_direction = this.exterior_facing;
        this.generateInterior();
//        this.interiorTeleportPos = this.interior_door_position.relative(interior_door_facing.getOpposite(), 1);

    }

    public void setExteriorDoorState(EnumDoorState doorState) {
        ServerWorld world = AIT.server.getLevel(exterior_dimension);
        assert world != null;
        TardisTileEntity tardisTileEntity = (TardisTileEntity) world.getBlockEntity(exterior_position);
        assert tardisTileEntity != null;
        tardisTileEntity.setDoorState(doorState);
    }

    public void setInteriorDoorState(EnumDoorState doorState) {
        ServerWorld world = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        assert world != null;
        BasicInteriorDoorTile interiorDoorTile = (BasicInteriorDoorTile) world.getBlockEntity(interior_door_position);
        assert interiorDoorTile != null;
        interiorDoorTile.setDoorState(doorState);

    }

    public void setExteriorType(EnumExteriorType exteriorType) {
        this.exteriorType = exteriorType;
        ServerWorld exteriorWorld = AIT.server.getLevel(exterior_dimension);
        assert exteriorWorld != null;
        TardisTileEntity tardisTileEntity = (TardisTileEntity) exteriorWorld.getBlockEntity(this.exterior_position);
        assert tardisTileEntity != null;
        tardisTileEntity.setExterior(exteriorType);
    }

    public void lockTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        assert playerentity != null;
        World world = playerentity.level;
        //this.lockedTardis = true;
        world.playSound(null, this.exterior_position.getX(),
                this.exterior_position.getY(), this.exterior_position.getZ(),
                AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        System.out.println(this.lockedTardis);
    }

    public void unlockTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        assert playerentity != null;
        World world = playerentity.level;
        this.lockedTardis = false;
        world.playSound(null, this.exterior_position.getX(),
                this.exterior_position.getY(), this.exterior_position.getZ(),
                AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        System.out.println(this.lockedTardis);
    }

    private void generateInterior() {
        ServerWorld tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
        BlockPos interiorCenterBlockPos = this.currentInterior.getCenterPosition();
        BlockPos interiorDoorBlockPos = this.currentInterior.getInteriorDoorPosition();
        BlockPos generateFromBlockPos = new BlockPos(this.center_position.getX() - interiorCenterBlockPos.getX(), this.center_position.getY() - interiorCenterBlockPos.getY(), this.center_position.getZ() - interiorCenterBlockPos.getZ());
        this.currentInterior.placeInterior(tardisWorld, generateFromBlockPos);
        this.interior_door_position = new BlockPos(generateFromBlockPos.getX() + interiorDoorBlockPos.getX(), generateFromBlockPos.getY() + interiorDoorBlockPos.getY(), generateFromBlockPos.getZ() + interiorDoorBlockPos.getZ());
        BlockState interiorDoorBlockState = Objects.requireNonNull(AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION)).getBlockState(interior_door_position);
        if (interiorDoorBlockState.getBlock() instanceof BasicInteriorDoorBlock) {
            this.interior_door_facing = interiorDoorBlockState.getValue(BasicInteriorDoorBlock.FACING);
            assert tardisWorld != null;
            TileEntity interiorDoorTileEntity = tardisWorld.getBlockEntity(this.interior_door_position);
            if (interiorDoorTileEntity instanceof BasicInteriorDoorTile) {
                ((BasicInteriorDoorTile) interiorDoorTileEntity).linked_tardis = this;
                ((BasicInteriorDoorTile) interiorDoorTileEntity).tardisID = this.tardisID;
            }
        }
    }

    public void __moveExterior(BlockPos newExteriorPosition, Direction newExteriorFacing, RegistryKey<World> newExteriorDimension) {
        this.exterior_position = newExteriorPosition;
        this.exterior_facing = newExteriorFacing;
        this.exterior_dimension = newExteriorDimension;

    }

    public void __setTargetLocation(BlockPos newTargetPosition, Direction newTargetFacing, RegistryKey<World> newTargetDimension) {
        this.target_dimension = newTargetDimension;
        this.targetPosition = newTargetPosition;
        this.target_facing_direction = newTargetFacing;
    }

    public void teleportToInterior(ServerPlayerEntity playerEntity) {
        System.out.println("Hey this is a thing");
        System.out.println(this.interior_door_position);
        // @TODO: Something breaks here that'll teleport the player to the void only on a server and I have no idea why!!!!
        if (playerEntity != null) {
            ServerWorld target_world = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
            ChunkPos chunkPos = new ChunkPos(this.interior_door_position);
            assert target_world != null;
//            target_world.getChunkSource().addRegionTicket(TicketType.POST_TELEPORT, chunkPos, 1, playerEntity.getId());
            playerEntity.stopRiding();
            ServerWorld oldWorld = playerEntity.getLevel();
            switch (this.interior_door_facing.getOpposite().toString()) {
                case "north": {
                    System.out.println("north");
//                    playerEntity.setLevel(target_world);
//                    playerEntity.moveTo(this.interior_door_position.getX() + 0.5, this.interior_door_position.getY(), this.interior_door_position.getZ() - 0.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    oldWorld.removePlayer(playerEntity, true);
                    playerEntity.revive();
                    playerEntity.gameMode.setLevel(target_world);
                    playerEntity.setLevel(target_world);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
                    BasicEventHooks.firePlayerChangedDimensionEvent(playerEntity, oldWorld.dimension(), target_world.dimension());
                    target_world.addDuringCommandTeleport(playerEntity);
                    playerEntity.connection.teleport(this.interior_door_position.getX() + 0.5, this.interior_door_position.getY(), this.interior_door_position.getZ() - 0.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
//                    BasicEventHooks.firePlayerChangedDimensionEvent(playerEntity, oldWorld.dimension(), target_world.dimension());
                    break;
                }
                case "south": {
                    System.out.println("south");
                    oldWorld.removePlayer(playerEntity, true);
                    playerEntity.revive();
                    playerEntity.gameMode.setLevel(target_world);
                    playerEntity.setLevel(target_world);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
                    BasicEventHooks.firePlayerChangedDimensionEvent(playerEntity, oldWorld.dimension(), target_world.dimension());
                    target_world.addDuringCommandTeleport(playerEntity);
                    playerEntity.connection.teleport(this.interior_door_position.getX() + 0.5, this.interior_door_position.getY(), this.interior_door_position.getZ() + 1.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
                    break;
                }
                case "east": {
                    System.out.println("east");
                    oldWorld.removePlayer(playerEntity, true);
                    playerEntity.revive();
                    playerEntity.gameMode.setLevel(target_world);
                    playerEntity.setLevel(target_world);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
                    BasicEventHooks.firePlayerChangedDimensionEvent(playerEntity, oldWorld.dimension(), target_world.dimension());
                    playerEntity.connection.teleport( this.interior_door_position.getX() + 1.5, this.interior_door_position.getY(), this.interior_door_position.getZ() + 0.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
                    break;
                }
                case "west": {
                    System.out.println("west");
                    oldWorld.removePlayer(playerEntity, true);
                    playerEntity.revive();
                    playerEntity.gameMode.setLevel(target_world);
                    playerEntity.setLevel(target_world);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
                    BasicEventHooks.firePlayerChangedDimensionEvent(playerEntity, oldWorld.dimension(), target_world.dimension());
                    playerEntity.connection.teleport(this.interior_door_position.getX() - 0.5, this.interior_door_position.getY(), this.interior_door_position.getZ() + 0.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    AIT.server.getPlayerList().sendLevelInfo(playerEntity, target_world);
                    AIT.server.getPlayerList().sendAllPlayerInfo(playerEntity);
                    break;
                }
            }
        }
    }

    public void positionForTardisChange(BlockPos bpos, Tardis TardiS, TardisTileEntity tte, UUID uuid) {
        TardisManager tardisManager = AIT.tardisManager;
        ServerWorld target_world = AIT.server.getLevel(TardiS.exterior_dimension);
        BlockPos exteriorPosition = new BlockPos(bpos);
        try {
            assert target_world != null;
            target_world.setBlockEntity(exteriorPosition, tte);
            target_world.setBlock(exteriorPosition, tte.getBlockState(), 1);
            Tardis tardis = tardisManager.createNewTardis(tte.linked_tardis_id, exteriorPosition, TardiS.exterior_dimension);
            tte.linked_tardis = tardis;
            uuid = tardis.tardisID;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void teleportToExterior(PlayerEntity playerEntity) {
        if (playerEntity instanceof ServerPlayerEntity) {
            ServerWorld target_world = AIT.server.getLevel(this.exterior_dimension);
            switch (this.exterior_facing.toString()) {
                case "north": {
                    System.out.println("north");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.exterior_position.getX() + 0.5, this.exterior_position.getY(), this.exterior_position.getZ() - 0.5, exterior_facing.toYRot(), playerEntity.xRot);
                    break;
                }
                case "south": {
                    System.out.println("south");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.exterior_position.getX() + 0.5, this.exterior_position.getY(), this.exterior_position.getZ() + 1.5, exterior_facing.toYRot(), playerEntity.xRot);
                    break;
                }
                case "east": {
                    System.out.println("east");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.exterior_position.getX() + 1.5, this.exterior_position.getY(), this.exterior_position.getZ() + 0.5, exterior_facing.toYRot(), playerEntity.xRot);
                    break;
                }
                case "west": {
                    System.out.println("west");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.exterior_position.getX() - 0.5, this.exterior_position.getY(), this.exterior_position.getZ() + 0.5, exterior_facing.toYRot(), playerEntity.xRot);
                    break;
                }
            }
        }
    }

    /*public static void getExteriorPosition(World world) {
        TileEntity te = world.getBlockEntity();
    }*/

    public Tardis(CompoundNBT tag) { // Loading
        this.owner = tag.getUUID("owner");
        this.tardisID = tag.getUUID("tardis_id");
        this.exterior_position = BlockPos.of(tag.getLong("exterior_position"));
        this.exterior_dimension = RegistryKey.create(RegistryKey.createRegistryKey(new ResourceLocation(tag.getString("exterior_dimension_registry_name"))), new ResourceLocation(tag.getString("exterior_dimension_resource_location")));
        this.grid_position = new Tuple<Integer, Integer>(tag.getInt("grid_position_x"), tag.getInt("grid_position_z"));
        this.currentInterior = TardisInteriors.getInteriorFromName(tag.getString("tardis_interior"));
        this.center_position = BlockPos.of(tag.getLong("center_position")); // Before we'd use to calculate it, but now we just grab from data, so if someone changes the config it won't break older tardises
        this.exterior_facing = Direction.byName(tag.getString("exterior_facing"));
        this.interior_door_position = BlockPos.of(tag.getLong("interior_door_position"));
        this.interior_door_facing = Direction.byName(tag.getString("interior_door_facing"));
        this.lockedTardis = tag.getBoolean("locked_tardis"); // Loqor is an idiot and fucked this up ~ Creativious
        if (tag.contains("target_dimension_registry_name") || tag.contains("target_position") || tag.contains("target_facing") || tag.contains("target_dimension_resource_location")) {
            this.targetPosition = BlockPos.of(tag.getLong("target_position"));
            this.target_dimension = RegistryKey.create(RegistryKey.createRegistryKey(new ResourceLocation(tag.getString("target_dimension_registry_name"))), new ResourceLocation(tag.getString("target_dimension_resource_location")));
            this.target_facing_direction = Direction.byName(tag.getString("target_facing"));
        }
        this.max_energy_storage = tag.getInt("max_energy_storage");
        this.current_energy = tag.getInt("current_energy");
        this.energy_recharge_rate = tag.getInt("energy_recharge_rate");
        this.exteriorType = EnumExteriorType.valueOf(tag.getString("exterior_type"));
        this.landed = Boolean.getBoolean("isLanded");

    }

    public CompoundNBT save() {
        CompoundNBT tag = new CompoundNBT();
        tag.putUUID("owner", this.owner);
        tag.putUUID("tardis_id", this.tardisID);
        tag.putLong("exterior_position", this.exterior_position.asLong());
        tag.putString("exterior_dimension_registry_name", this.exterior_dimension.getRegistryName().toString());
        tag.putString("exterior_dimension_resource_location", this.exterior_dimension.location().toString());
        tag.putInt("grid_position_x", this.grid_position.getA());
        tag.putInt("grid_position_z", this.grid_position.getB());
        tag.putString("tardis_interior", this.currentInterior.toString());
        tag.putString("exterior_facing", this.exterior_facing.toString());
        tag.putLong("interior_door_position", this.interior_door_position.asLong());
        tag.putLong("center_position", this.center_position.asLong());
        tag.putString("interior_door_facing", this.interior_door_facing.toString());
        tag.putBoolean("locked_tardis", this.lockedTardis);
        if (target_dimension != null && targetPosition != null && target_facing_direction != null) {
            tag.putString("target_dimension_registry_name", this.target_dimension.getRegistryName().toString()); // IT IS NOT NULL YOU IDIOT I ALREADY CHECKED FOR IT
            tag.putString("target_dimension_resource_location", this.target_dimension.location().toString()); // @todo FIX THIS SHIT CREATIVIOUS
            tag.putLong("target_position", this.targetPosition.asLong());
            tag.putString("target_facing", this.target_facing_direction.toString());
        }
        tag.putInt("max_energy_storage", this.max_energy_storage);
        tag.putInt("current_energy", this.current_energy);
        tag.putInt("energy_recharge_rate", this.energy_recharge_rate);
        tag.putString("exterior_type", this.exteriorType.toString());
        tag.putBoolean("isLanded", this.landed);
        return tag;
    }

    @Override
    public int receiveEnergy(int receiveAmount, boolean simulate) {
        if (current_energy + receiveAmount > max_energy_storage) {
            if (!simulate) {
                current_energy += (receiveAmount - ((current_energy + receiveAmount) -max_energy_storage));
            }
            return (receiveAmount - ((current_energy + receiveAmount) -max_energy_storage));
        } else {
            if (!simulate) {
                current_energy += receiveAmount;
            }
            return receiveAmount;
        }
    }

    @Override
    public int extractEnergy(int extractAmount, boolean simulate) {
        // Ignore boolean
        if (extractAmount > current_energy) {
            if (!simulate) {
                current_energy -= current_energy;
            }
            return current_energy;
        } else {
            if (!simulate) {
                current_energy -= extractAmount;
            }
            return extractAmount;
        }
    }

    @Override
    public int getEnergyStored() {
        return current_energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return max_energy_storage;
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
