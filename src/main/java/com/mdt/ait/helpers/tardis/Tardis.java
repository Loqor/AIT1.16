package com.mdt.ait.helpers.tardis;

import com.mdt.ait.world.dimensions.TardisDimensionFactory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.util.UUID;

// Need to make sure it's telling the tardis manager when it get's dirty

public class Tardis {
    public final RegistryKey<World> interior_key;
    public final UUID owner;
    public @Nullable BlockPos exterior_position;
    public boolean hasGenerated = false;
    public RegistryKey<World> tardis_dimension;

    public Tardis(UUID player) {
        interior_key = TardisDimensionFactory.getTardisDimensionForPlayer(player);
        owner = player;
    }

    //=========================================== SERIALISATION ======================================================
    public Tardis(UUID owner, CompoundNBT nbt) {
        this(owner);
        if(nbt.contains("ext_pos")) exterior_position = BlockPos.of(nbt.getLong("ext_pos"));
        hasGenerated = nbt.getBoolean("has_gen");
    }
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putUUID("id",owner);
        nbt.putBoolean("has_gen",hasGenerated);
        if (exterior_position != null) nbt.putLong("ext_pos",exterior_position.asLong());
        return nbt;
    }
}