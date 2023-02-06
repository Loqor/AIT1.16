package com.mdt.ait.core.init.enums;

import com.mdt.ait.common.tileentities.PhoneBoothTile;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumPhoneBoothType implements IStringSerializable {

    PHONE_BOOTH("phone_booth", PhoneBoothTile::new);

    public final Supplier<PhoneBoothTile> tileEntity;
    public final String name;

    EnumPhoneBoothType(String _name, Supplier<PhoneBoothTile> _te) {
        tileEntity = _te;
        name = _name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}