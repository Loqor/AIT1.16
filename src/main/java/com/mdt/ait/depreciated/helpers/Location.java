package com.mdt.ait.depreciated.helpers;

import com.mdt.ait.depreciated.helpers.tardis.Position;
import net.minecraft.dispenser.IPosition;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

import java.io.Serializable;

public class Location implements Serializable {

    private Position position;
    private String dimension;
    private String biome;
    private static final long serialVersionUID = 1L;

    public Location(final BlockPos bpos, final RegistryKey key) {
        this.position = new Position(bpos.getX(), bpos.getY(), bpos.getZ());
        this.dimension = key.getRegistryName().toString();
        this.biome = key.getRegistryName().toString();
    }

    public BlockPos getBlockPosition() {
        return new BlockPos((IPosition)this.position);
    }

    public String getDimension() {
        return this.dimension;
    }

    public String getBiome() {
        return this.biome;
    }

    public RegistryKey dimension() {
        return RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(this.dimension));
    }

    public RegistryKey biome() {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(this.biome));
    }

    public Position getPosition() {
        return this.position;
    }
}
