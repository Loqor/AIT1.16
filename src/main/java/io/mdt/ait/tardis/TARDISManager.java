package io.mdt.ait.tardis;

import io.mdt.ait.NBTSerializeable;
import io.mdt.ait.NBTUnserializeable;
import io.mdt.ait.tardis.exterior.TARDISExteriors;
import io.mdt.ait.tardis.interior.TARDISInteriors;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class TARDISManager {

    private static final TARDISMap tardises = new TARDISMap();
    private static final TARDISWorldData savedData = new TARDISWorldData();

    @SuppressWarnings("InstantiationOfUtilityClass") // hide the warning. instance is used for NBT serialization
    private static final TARDISManager instance = new TARDISManager();

    private TARDISManager() { }

    public static TARDIS create(BlockPos position, RegistryKey<World> dimension) {
        savedData.setDirty(true);
        System.out.println("AITDEBUG" + TARDISInteriors.get("dev"));
        TARDIS tardis = new TARDISBuilder(UUID.randomUUID())
                .at(position, dimension)
                .exterior(TARDISExteriors.get("basic"))
                .interior(TARDISInteriors.get("dev"))
                .build();

        tardises.put(tardis);
        return tardis;
    }

    public static TARDIS findTARDIS(UUID uuid) {
        return tardises.get(uuid);
    }

    public static UUID findUUID(int index) {
        return tardises.get(index);
    }

    public static TARDIS findTARDIS(BlockPos pos) {
        return TARDISManager.findTARDIS(TARDISManager.findUUID(pos));
    }

    public static UUID findUUID(BlockPos pos) {
        return TARDISManager.findUUID(TARDISUtil.getIndexByPos(pos));
    }

    public static TARDISMap getTARDISMap() {
        return tardises;
    }

    public static TARDISWorldData getSavedData() {
        return savedData;
    }

    public static TARDISManager getInstance() {
        return instance;
    }

    /**
     *
     * @return
     * @implNote DO NOT USE THIS METHOD UNDER ANY CIRCUMSTANCES. IT IS MADE FOR {@link TARDIS} CLASS.
     */
    public static int getLastIndex() {
        return tardises.size() + 1; // Need to add 1, because when the TARDIS is created, it is not being put into the map right away.
    }

    public static class Serializer implements NBTSerializeable<TARDISManager>, NBTUnserializeable<TARDISManager> {

        private static final TARDISMap.Serializer mapSerializer = new TARDISMap.Serializer();

        @Override
        public CompoundNBT serialize(TARDISManager manager, CompoundNBT nbt) {
            mapSerializer.serialize(TARDISManager.getTARDISMap(), nbt);
            savedData.setDirty(false);
            return nbt;
        }

        @Override
        public TARDISManager unserialize(CompoundNBT nbt) {
            TARDISManager.getTARDISMap().set(mapSerializer.unserialize(nbt));
            savedData.setDirty(false);
            return null;
        }
    }
}
