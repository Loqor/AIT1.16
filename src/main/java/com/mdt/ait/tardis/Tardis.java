package com.mdt.ait.tardis;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class Tardis {

    public BlockPos exterior_position;
    public BlockPos interior_door_position;
    public Direction exterior_facing;
    public Direction interior_door_facing;
    public BlockPos center_position;
    public Tuple<Integer, Integer> grid_position;
    public RegistryKey<World> exterior_dimension;
    public final UUID owner;

    public final UUID tardisID;

    public Tardis(UUID player, BlockPos exterior_position, RegistryKey<World> exterior_dimension, UUID tardisID, Tuple<Integer, Integer> grid_position) {
        this.owner = player;
        this.exterior_dimension = exterior_dimension;
        this.exterior_position = exterior_position;
        this.grid_position = grid_position;
        this.tardisID = tardisID;
    }

    public Tardis(CompoundNBT tag) { // Loading
        this.owner = tag.getUUID("owner");
        this.tardisID = tag.getUUID("tardis_id");
        this.exterior_position = BlockPos.of(tag.getLong("exterior_position"));
        this.exterior_dimension = RegistryKey.create(RegistryKey.createRegistryKey(new ResourceLocation(tag.getString("exterior_dimension_registry_name"))), new ResourceLocation(tag.getString("exterior_dimension_resource_location")));
        this.grid_position = new Tuple<Integer, Integer>(tag.getInt("grid_position_x"), tag.getInt("grid_position_z"));

    }

    public CompoundNBT save() {
        System.out.println("Tardis Saving");
        CompoundNBT tag = new CompoundNBT();
        tag.putUUID("owner", this.owner);
        tag.putUUID("tardis_id", this.tardisID);
        tag.putLong("exterior_position", this.exterior_position.asLong());
        tag.putString("exterior_dimension_registry_name", this.exterior_dimension.getRegistryName().toString());
        tag.putString("exterior_dimension_resource_location", this.exterior_dimension.location().toString());
//        tag.putLong("center_position", this.center_position.asLong()); // Worry about this later
        tag.putInt("grid_position_x", this.grid_position.getA());
        tag.putInt("grid_position_z", this.grid_position.getB());
        return tag;
    }


}
