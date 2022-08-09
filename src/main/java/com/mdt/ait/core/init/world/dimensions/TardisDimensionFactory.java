package com.mdt.ait.core.init.world.dimensions;

import com.mdt.ait.AIT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import java.util.UUID;

public class TardisDimensionFactory {

    public static final RegistryKey<DimensionType> TYPE_KEY = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY,
            new ResourceLocation(AIT.MOD_ID, "tardis_dimension_type"));

    public static Dimension createTardisDimension(MinecraftServer server) {
        return new Dimension(() -> getTardisDimensionType(server), new TardisChunkGen(server));
    }

    public static DimensionType getTardisDimensionType(MinecraftServer server) {
        return server.registryAccess().registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY).getOrThrow(TYPE_KEY);
    }

    public static RegistryKey<World> getTardisDimensionForPlayer(UUID player) {
        return RegistryKey.create(Registry.DIMENSION_REGISTRY,
                new ResourceLocation(AIT.MOD_ID, player.toString()));
    }
}