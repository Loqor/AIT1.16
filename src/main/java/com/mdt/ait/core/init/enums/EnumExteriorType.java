package com.mdt.ait.core.init.enums;

import com.mdt.ait.common.tileentities.TardisTileEntity;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumExteriorType implements IStringSerializable {

    BASIC_BOX("basic_box", TardisTileEntity::new),
    MINT_BOX("mint_box", TardisTileEntity::new),
    CORAL_BOX("coral_box",TardisTileEntity::new);

    public final Supplier<TardisTileEntity> tileEntity;
    public final String name;

    EnumExteriorType(String _name, Supplier<TardisTileEntity> _te) {
        tileEntity = _te;
        name = _name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}