package io.mdt.ait;

import net.minecraft.nbt.CompoundNBT;

public interface NBTSerializeable<T> {
    /**
     * Serializes the class to {@link CompoundNBT}
     *
     * @param t instance of the class that needs to be serialized
     * @param nbt {@link CompoundNBT} where the class will be serialized to
     * @return {@link CompoundNBT} with the serialized class
     */
    CompoundNBT serialize(T t, CompoundNBT nbt);

    /**
     * Serializes the class to {@link CompoundNBT}
     * 
     * @implNote This method creates new {@link CompoundNBT}, and if you want to serialize the class into existing {@link CompoundNBT}, use {@link NBTSerializeable#serialize(Object, CompoundNBT)}
     * @param t instance of the class that needs to be serialized
     * @return {@link CompoundNBT} with the serialized class
     */
    default CompoundNBT serialize(T t) {
        return this.serialize(t, new CompoundNBT());
    }
}
