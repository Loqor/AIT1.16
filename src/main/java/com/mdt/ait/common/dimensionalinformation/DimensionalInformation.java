package com.mdt.ait.common.dimensionalinformation;

import com.mdt.ait.core.init.enums.EnumDangerLevel;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.WeightedList;
import net.minecraft.world.World;

public class DimensionalInformation {
    public RegistryKey<World> dimension;

    public EnumDangerLevel dangerLevel;

    public DimensionalInformation(RegistryKey<World> dimension, EnumDangerLevel dangerLevel) {
        this.dimension = dimension;
        this.dangerLevel = dangerLevel;
        // @TODO: Add a way to say "Danger Information"
    }
}
