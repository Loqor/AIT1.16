package com.mdt.ait.tardis.interiors;

import com.mdt.ait.AIT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;

public class DevInterior extends TardisInterior{
    public DevInterior(ServerWorld tardisWorld) {
        super(new ResourceLocation(AIT.MOD_ID, "dev_interior"), tardisWorld, "Dev Interior");
    }
}
