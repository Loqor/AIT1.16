package com.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.common.blocks.BasicInteriorDoorBlock;
import com.mdt.ait.common.blocks.TardisBlock;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.tardis.interiors.TardisInterior;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

import java.util.Objects;
import java.util.UUID;

public class Tardis {

    public BlockPos exterior_position;
    public BlockPos interior_door_position;
    public Direction exterior_facing;
    public Direction interior_door_facing;
    public final BlockPos center_position;

    public BlockPos interiorTeleportPos;
    public TardisInterior currentInterior;
    public final Tuple<Integer, Integer> grid_position;
    public RegistryKey<World> exterior_dimension;
    public final UUID owner;

    public final UUID tardisID;

    public Tardis(UUID player, BlockPos exterior_position, RegistryKey<World> exterior_dimension, UUID tardisID, Tuple<Integer, Integer> grid_position) {
        System.out.println("Creating new tardis");
        this.owner = player;
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
        this.interiorTeleportPos = this.interior_door_position;
        switch (interior_door_facing.toString()) {
            case "north": {
                this.interiorTeleportPos.south(1);
            }
            case "south": {
                this.interiorTeleportPos.north(1);
            }
            case "east": {
                this.interiorTeleportPos.west(1);
            }
            case "west": {
                this.interiorTeleportPos.east(1);
            }
        }
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
        }
    }

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
        this.interiorTeleportPos = this.interior_door_position;
        switch (interior_door_facing.toString()) {
            case "north": {
                this.interiorTeleportPos.south(1);
            }
            case "south": {
                this.interiorTeleportPos.north(1);
            }
            case "east": {
                this.interiorTeleportPos.west(1);
            }
            case "west": {
                this.interiorTeleportPos.east(1);
            }
        }

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
        return tag;
    }


}
