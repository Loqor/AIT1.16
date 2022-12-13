package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import java.awt.*;

public class AITDimensions {
    // https://misode.github.io/dimension/
    public static RegistryKey<World> TARDIS_DIMENSION;
    public static RegistryKey<World> GALLIFREY;
    public static RegistryKey<World> MONDAS;
    public static RegistryKey<World> VORTEX_DIMENSION;

    public static void init() {
        TARDIS_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(AIT.MOD_ID, "tardis_dimension"));
        GALLIFREY = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(AIT.MOD_ID, "gallifrey"));
        MONDAS = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(AIT.MOD_ID, "mondas"));
        VORTEX_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(AIT.MOD_ID, "vortex_dimension"));
    }
}
