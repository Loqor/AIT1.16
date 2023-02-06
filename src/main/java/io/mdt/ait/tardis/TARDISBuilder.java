package io.mdt.ait.tardis;

import io.mdt.ait.tardis.exterior.TARDISExterior;
import io.mdt.ait.tardis.interior.TARDISInterior;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class TARDISBuilder {

    private final UUID uuid;

    private BlockPos position;
    private RegistryKey<World> dimension;
    private TARDISExterior exterior;
    private TARDISInterior interior;

    public TARDISBuilder(UUID uuid) {
        this.uuid = uuid;
    }

    public TARDISBuilder at(BlockPos position, RegistryKey<World> dimension) {
        this.position = position;
        this.dimension = dimension;
        return this;
    }

    public TARDISBuilder exterior(TARDISExterior exterior) {
        this.exterior = exterior;
        return this;
    }

    public TARDISBuilder interior(TARDISInterior interior) {
        this.interior = interior;
        return this;
    }

    public TARDIS build() {
        return new TARDIS(
                this.uuid, this.position, this.dimension, this.exterior, this.interior, null, true
        );
    }
}
