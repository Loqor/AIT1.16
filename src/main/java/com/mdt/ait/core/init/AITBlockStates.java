package com.mdt.ait.core.init;

import com.mdt.ait.core.init.enums.EnumExteriorType;
import net.minecraft.state.EnumProperty;

public class AITBlockStates {
    public static final EnumProperty<EnumExteriorType> TARDIS_EXTERIOR = EnumProperty.create("tardis_ext", EnumExteriorType.class);
}
