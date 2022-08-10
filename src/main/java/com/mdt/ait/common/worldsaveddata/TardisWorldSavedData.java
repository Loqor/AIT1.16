package com.mdt.ait.common.worldsaveddata;

import com.mdt.ait.AIT;
import com.mdt.ait.tardis.TardisManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

import java.util.function.Supplier;

public class TardisWorldSavedData extends WorldSavedData{

    /*
    WorldSavedData doesn't exist in later versions, once updated to later versions this won't work


     */
    public static final String TARDIS_WORLD_SAVED_DATA = AIT.MOD_ID + "_DATA";

    public static TardisManager tardisManager;

    public TardisWorldSavedData(TardisManager tardisManagerInstance) {
        super(TARDIS_WORLD_SAVED_DATA);
        tardisManager = tardisManagerInstance;
    }
    public TardisWorldSavedData(String s, TardisManager tardisManagerInstance) {
        super(s);
        tardisManager = tardisManagerInstance;
    }

    @Override
    public void load(CompoundNBT tag) {
        System.out.println("TardisWorldSavedData: Loading");
        tardisManager.load(tag);
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        tag = tardisManager.save(tag);

        return tag;
    }

    @Override
    public void setDirty(boolean isDirty) {
        super.setDirty(isDirty);
    }

    public Supplier<TardisWorldSavedData> getSupplier() {
        return () -> this;
    }
}
