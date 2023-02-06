package io.mdt.ait.tardis.interior;

import java.util.HashMap;
import java.util.Map;

public class TARDISInteriors {

    private static final Map<String, TARDISInterior> interiors = new HashMap<>();

    /**
     * All default interiors are registered here!
     */
    public static void init() {
        TARDISInteriors.register(new DevInterior());
        TARDISInteriors.register(new AirInterior());
    }

    public static void register(TARDISInterior interior) {
        interiors.put(interior.getId(), interior);
    }

    public static TARDISInterior get(String id) {
        return interiors.get(id);
    }
}
