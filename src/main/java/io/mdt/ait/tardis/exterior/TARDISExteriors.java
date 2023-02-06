package io.mdt.ait.tardis.exterior;

import java.util.HashMap;
import java.util.Map;

public class TARDISExteriors {

    private static final Map<String, TARDISExterior> exteriors = new HashMap<>();

    /**
     * All default exteriors are registered here!
     */
    public static void init() {
        TARDISExteriors.register(new BasicBoxExterior());
    }

    public static void register(TARDISExterior exterior) {
        exteriors.put(exterior.getId(), exterior);
    }

    public static TARDISExterior get(String id) {
        return exteriors.get(id);
    }
}
