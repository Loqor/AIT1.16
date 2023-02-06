package io.mdt.ait.tardis.exterior;

import io.mdt.ait.NBTSerializeable;
import io.mdt.ait.NBTUnserializeable;
import io.mdt.ait.tardis.PortalInfo;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TranslationTextComponent;

public abstract class TARDISExterior {

    private final String id;
    private final TranslationTextComponent name;

    public TARDISExterior(String id, String translation) {
        this.id = id;
        this.name = new TranslationTextComponent(translation);
    }

    public abstract <T extends Entity> EntityModel<T> model();
    public abstract PortalInfo portal();

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name.getString();
    }

    public static class Serializer implements NBTSerializeable<TARDISExterior>, NBTUnserializeable<TARDISExterior> {

        @Override
        public CompoundNBT serialize(TARDISExterior exterior, CompoundNBT nbt) {
            nbt.putString("id", exterior.id);
            return nbt;
        }

        @Override
        public TARDISExterior unserialize(CompoundNBT nbt) {
            return TARDISExteriors.get(nbt.getString("id"));
        }
    }
}
