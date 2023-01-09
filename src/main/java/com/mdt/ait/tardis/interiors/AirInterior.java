package com.mdt.ait.tardis.interiors;

import com.mdt.ait.AIT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;

public class AirInterior extends TardisInterior {

    public AirInterior(ServerWorld tardisWorld) {
        super(new ResourceLocation(AIT.MOD_ID, "air_interior"), tardisWorld, "Air Interior");
    }

}
