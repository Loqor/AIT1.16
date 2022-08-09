package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.awt.*;

public class AITDimensions {
    public static final RegistryKey<World> TARDIS_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(AIT.MOD_ID, "tardis_dimension"));
}
