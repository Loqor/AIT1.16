package com.mdt.ait.core.init.enums;

import com.mdt.ait.common.tileentities.TardisTileEntity;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumExteriorType implements IStringSerializable {

    BASIC_BOX("basic_box", TardisTileEntity::new),
    MINT_BOX("mint_box", TardisTileEntity::new),
    CORAL_BOX("coral_box",TardisTileEntity::new),
    POSTER_BOX("poster_box", TardisTileEntity::new),
    BAKER_BOX("baker_box", TardisTileEntity::new),
    TYPE_40_TT_CAPSULE("type_40_tt_capsule", TardisTileEntity::new),
    HELLBENT_TT_CAPSULE("hellbent_tt_capsule", TardisTileEntity::new),
    NUKA_COLA_EXTERIOR("nuka_cola_exterior", TardisTileEntity::new),
    SIEGE_MODE("siege_mode", TardisTileEntity::new),
    ARCADE_CABINET_EXTERIOR("arcade_cabinet_exterior", TardisTileEntity::new),
    CUSHING_EXTERIOR("cushing_exterior", TardisTileEntity::new),
    CLASSIC_EXTERIOR("classic_exterior", TardisTileEntity::new),
    HARTNELL_EXTERIOR("hartnell_exterior", TardisTileEntity::new),
    HUDOLIN_EXTERIOR("hudolin_exterior", TardisTileEntity::new),
    TX3_EXTERIOR("tx3_exterior", TardisTileEntity::new),
    TARDIM_EXTERIOR("tardim_exterior", TardisTileEntity::new),
    SHALKA_EXTERIOR("shalka_exterior", TardisTileEntity::new),
    BOOTH_EXTERIOR("booth_exterior", TardisTileEntity::new),
    STEVE_EXTERIOR("steve_exterior", TardisTileEntity::new),
    FALLOUT_SHELTER_EXTERIOR("fallout_shelter_exterior", TardisTileEntity::new),
    RANI_EXTERIOR("rani_exterior", TardisTileEntity::new),
    CLOCK_EXTERIOR("clock_exterior", TardisTileEntity::new);

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