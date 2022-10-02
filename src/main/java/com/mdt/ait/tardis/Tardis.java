package com.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import com.mdt.ait.common.tileentities.TardisTileEntity;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.core.init.AITSounds;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Objects;
import java.util.UUID;

public class Tardis {

    public BlockPos exterior_position;
    public BlockPos interior_door_position;
    public Direction exterior_facing;
    public Direction interior_door_facing;
    public final BlockPos center_position;
    public TardisInterior currentInterior;
    public final Tuple<Integer, Integer> grid_position;
    public RegistryKey<World> exterior_dimension;

    public BlockPos console_position;
    public final UUID owner;
    public boolean lockedTardis;

    public final UUID tardisID;

    public Tardis(UUID player, BlockPos exterior_position, RegistryKey<World> exterior_dimension, UUID tardisID, Tuple<Integer, Integer> grid_position, boolean lockedTardis) {
        System.out.println("Creating new tardis");
        this.owner = player;
        this.lockedTardis = lockedTardis;
        this.exterior_dimension = exterior_dimension;
        this.exterior_position = exterior_position;
        this.grid_position = grid_position;
        this.tardisID = tardisID;
        this.currentInterior = TardisInteriors.devInterior;
        this.center_position = new BlockPos(TardisConfig.tardis_dimension_start_x-(TardisConfig.tardis_area_x * grid_position.getA()) + ((TardisConfig.tardis_area_x - 1)/2) + 1,TardisConfig.tardis_center_y,TardisConfig.tardis_dimension_start_z-(TardisConfig.tardis_area_z * grid_position.getB()) + ((TardisConfig.tardis_area_z - 1)/2) + 1);
        BlockState exteriorBlockState = Objects.requireNonNull(AIT.server.getLevel(exterior_dimension)).getBlockState(exterior_position);
        if (exteriorBlockState.getBlock() instanceof TardisBlock) {
            this.exterior_facing = exteriorBlockState.getValue(TardisBlock.FACING);
        }
        this.generateInterior();
//        this.interiorTeleportPos = this.interior_door_position.relative(interior_door_facing.getOpposite(), 1);

    }

    public void lockTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
        World world = playerentity.level;
        //this.lockedTardis = true;
        world.playSound(null, this.exterior_position.getX(),
                this.exterior_position.getY(), this.exterior_position.getZ(),
                AITSounds.TARDIS_LOCK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        System.out.println(this.lockedTardis);
    }

    public void unlockTardis(ItemUseContext context, BlockPos blockpos, BlockState blockstate, Block block) {
        PlayerEntity playerentity = context.getPlayer();
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
            TileEntity interiorDoorTileEntity = tardisWorld.getBlockEntity(this.interior_door_position);
            if (interiorDoorTileEntity instanceof BasicInteriorDoorTile) {
                ((BasicInteriorDoorTile) interiorDoorTileEntity).linked_exterior = this;
            }
        }
    }

    public void teleportExteriorTo(RegistryKey<World> dimension, BlockPos position, Direction facing) {
        ServerWorld oldWorld = AIT.server.getLevel(exterior_dimension);
        ServerWorld newWorld = AIT.server.getLevel(dimension);
        oldWorld.destroyBlock(exterior_position, true);
        newWorld.setBlock(position, new TardisBlock().defaultBlockState(), 1);
    }

    public void teleportToInterior(PlayerEntity playerEntity) {
        if (playerEntity instanceof ServerPlayerEntity) {
            ServerWorld target_world = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION);
            switch (this.interior_door_facing.getOpposite().toString()) {
                case "north": {
                    System.out.println("north");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.interior_door_position.getX() + 0.5, this.interior_door_position.getY(), this.interior_door_position.getZ() - 0.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    break;
                }
                case "south": {
                    System.out.println("south");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.interior_door_position.getX() + 0.5, this.interior_door_position.getY(), this.interior_door_position.getZ() + 1.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    break;
                }
                case "east": {
                    System.out.println("east");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.interior_door_position.getX() + 1.5, this.interior_door_position.getY(), this.interior_door_position.getZ() + 0.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
                    break;
                }
                case "west": {
                    System.out.println("west");
                    ((ServerPlayerEntity) playerEntity).teleportTo(target_world, this.interior_door_position.getX() - 0.5, this.interior_door_position.getY(), this.interior_door_position.getZ() + 0.5, interior_door_facing.getOpposite().toYRot(), playerEntity.xRot);
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
            target_world.setBlockEntity(exteriorPosition, tte);
            target_world.setBlock(exteriorPosition, tte.getBlockState(), 1);
            Tardis tardis = tardisManager.createTardis(tte.linked_tardis_id, exteriorPosition, TardiS.exterior_dimension);
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
        this.lockedTardis = Boolean.valueOf(false);

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
        tag.putBoolean("lockedTardis", false);
        return tag;
    }
}
