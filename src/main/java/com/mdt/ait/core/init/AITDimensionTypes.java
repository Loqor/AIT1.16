package com.mdt.ait.core.init;

import com.mdt.ait.AIT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;

public class AITDimensionTypes {
    // https://misode.github.io/dimension-type/

    public static final RegistryKey<DimensionType> TARDIS_DIMENSION_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(AIT.MOD_ID, "tardis_dimension_type"));

}
