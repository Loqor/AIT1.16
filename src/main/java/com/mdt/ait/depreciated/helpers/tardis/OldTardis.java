package com.mdt.ait.depreciated.helpers.tardis;

import com.mdt.ait.depreciated.helpers.Location;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.*;

import com.mdt.ait.core.init.world.dimensions.TardisDimensionFactory;

// Need to make sure it's telling the tardis manager when it get's dirty

public class OldTardis {
    public RegistryKey<World> interior_key;
    public final UUID owner;
    public @Nullable
    BlockPos exterior_position;
    public @Nullable
    BlockPos interior_door_position;
    public boolean hasGenerated = false;
    private Location current_location;
    private Location previous_location;

    public List<BlockPos> door_list = new ArrayList<>();
    public List<RegistryKey<World>> exterior_dim = new ArrayList<>();

    public OldTardis(UUID player) {
        interior_key = TardisDimensionFactory.getTardisDimensionForPlayer(player);
        owner = player;
    }

    public Location getCurrentLocation() {
        return this.current_location;
    }

    public void setCurrentLocation(final BlockPos bpos, final RegistryKey registryKey) {
        this.current_location = new Location(bpos, registryKey);
    }

    public Location getPreviousLocation() {
        return this.previous_location;
    }

    public void setPreviousLocation(final BlockPos pos, final RegistryKey registryKey) {
        this.previous_location = new Location(pos, registryKey);
    }

    public void setPreviousLocation(final Location loc) {
        this.previous_location = new Location(loc.getBlockPosition(), loc.dimension());
    }

    //=========================================== SERIALISATION ======================================================
    public OldTardis(UUID owner, CompoundNBT nbt) {
        this(owner);
        if (nbt.contains("ext_pos")) exterior_position = BlockPos.of(nbt.getLong("ext_pos"));
        interior_key = TardisDimensionFactory.getTardisDimensionForPlayer(owner);
        if (nbt.contains("interior_door_pos")) interior_door_position = BlockPos.of(nbt.getLong("interior_door_pos"));
        hasGenerated = nbt.getBoolean("has_gen");
    }

    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putUUID("id", owner);
        nbt.putBoolean("has_gen", hasGenerated);
        if (exterior_position != null) nbt.putLong("ext_pos", exterior_position.asLong());
        if (interior_door_position != null) nbt.putLong("interior_door_pos", interior_door_position.asLong());
        if (current_location != null) nbt.putString("ext_dim", (current_location.toString()));
        return nbt;
    }
}