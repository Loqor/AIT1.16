package io.mdt.ait.tardis;

import com.mdt.ait.AIT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

/**
 * Saves TARDIS dimension data.
 *
 * @implNote WorldSavedData doesn't exist in later versions, once updated to later versions this won't work
 */
public class TARDISWorldData extends WorldSavedData {

    private final TARDISManager.Serializer managerSerializer = new TARDISManager.Serializer();

    public TARDISWorldData() {
        super(AIT.MOD_ID);
    }

    @Override
    public void load(CompoundNBT nbt) {
        this.managerSerializer.unserialize(nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        return this.managerSerializer.serialize(TARDISManager.getInstance(), nbt);
    }
}
