package com.mdt.ait.tardis;

import com.mdt.ait.AIT;
import com.mdt.ait.core.init.AITDimensions;
import com.mdt.ait.tardis.interiors.AirInterior;
import com.mdt.ait.tardis.interiors.DevInterior;
import com.mdt.ait.tardis.interiors.PristineInterior;
import com.mdt.ait.tardis.interiors.TardisInterior;
import net.minecraft.world.server.ServerWorld;

public class TardisInteriors {

    public static ServerWorld tardisWorld;
    public static TardisInterior devInterior;
    public static TardisInterior airInterior;
    public static TardisInterior pristineInterior;

    public static void init() {
        // For right now, all interiors are static
        tardisWorld = AIT.server.getLevel(AITDimensions.TARDIS_DIMENSION); // Get the tardisWorld
        devInterior = new DevInterior(tardisWorld);
        airInterior = new AirInterior(tardisWorld);
        pristineInterior = new PristineInterior(tardisWorld);
    }

    public static TardisInterior getInteriorFromName(String name) {
        switch (name) { //Ignore the warning this will be efficient when we have more interiors
            case "Dev Interior":
                return devInterior;
            case "Air Interior":
                return airInterior;
            case "Pristine Interior":
                return pristineInterior;
            default:
                return devInterior;
        }
    }

    /*public static TardisInterior getNextInterior(TardisInterior tardisInterior) {
        if (devInterior.equals(tardisInterior)) {
            return airInterior;
        } else if (airInterior.equals(tardisInterior)) {
            return pristineInterior;
        } else if (pristineInterior.equals(tardisInterior)) {
            return devInterior;
        }
        return devInterior;
    }*/
}
