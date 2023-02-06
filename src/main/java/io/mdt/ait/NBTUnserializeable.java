package io.mdt.ait;

import net.minecraft.nbt.CompoundNBT;

public interface NBTUnserializeable<T> {
    /**
     * Unserializes a {@link CompoundNBT}
     *
     * @param nbt NBT that needs to be unserialized
     * @return unserialized instance of the class
     */
    T unserialize(CompoundNBT nbt);
}
