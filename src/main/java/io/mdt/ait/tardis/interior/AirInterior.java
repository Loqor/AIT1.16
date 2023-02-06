package io.mdt.ait.tardis.interior;

import com.mdt.ait.AIT;
import net.minecraft.util.ResourceLocation;

public class AirInterior extends TARDISInterior {

    public AirInterior() {
        super("air", "interior.ait.air", new ResourceLocation(AIT.MOD_ID, "interior/air"));
    }
}
