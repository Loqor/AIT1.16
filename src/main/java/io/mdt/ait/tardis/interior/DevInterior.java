package io.mdt.ait.tardis.interior;

import com.mdt.ait.AIT;
import net.minecraft.util.ResourceLocation;

public class DevInterior extends TARDISInterior {

    public DevInterior() {
        super("dev", "interior.ait.dev", new ResourceLocation(AIT.MOD_ID, "interior/dev"));
    }
}
