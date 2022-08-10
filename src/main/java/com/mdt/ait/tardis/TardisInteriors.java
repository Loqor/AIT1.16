package com.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.tardis.interiors.DevInterior;
import com.mdt.ait.tardis.interiors.TardisInterior;
import net.minecraft.world.server.ServerWorld;

public class TardisInteriors {

    public static ServerWorld tardisWorld;
    public static TardisInterior devInterior;

    public static void init() {
        // For right now, all interiors are static, therefore do not move the InteriorDoor, your position to be teleported to won't change
        tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION); // Get the tardisWorld
        devInterior = new DevInterior(tardisWorld);

    }

    public static TardisInterior getInteriorFromName(String name) {
        switch (name) { // Ignore the warning this will be efficient when we have more interiors
            case "Dev Interior":
                return devInterior;
            default:
                return null;
        }
    }
}
