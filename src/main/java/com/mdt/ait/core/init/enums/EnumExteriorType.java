package com.mdt.ait.core.init.enums;

import com.mdt.ait.common.tileentities.TardisTileEntity;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumExteriorType implements IStringSerializable {

    BASIC_BOX("basic_box", TardisTileEntity::new), //0
    MINT_BOX("mint_box", TardisTileEntity::new), //1
    CORAL_BOX("coral_box",TardisTileEntity::new), //2
    POSTER_BOX("poster_box", TardisTileEntity::new), //3
    BAKER_BOX("baker_box", TardisTileEntity::new), //4
    TYPE_40_TT_CAPSULE("type_40_tt_capsule", TardisTileEntity::new), //5
    HELLBENT_TT_CAPSULE("hellbent_tt_capsule", TardisTileEntity::new), //6
    NUKA_COLA_EXTERIOR("nuka_cola_exterior", TardisTileEntity::new), //7
    SIEGE_MODE("siege_mode", TardisTileEntity::new), //8
    ARCADE_CABINET_EXTERIOR("arcade_cabinet_exterior", TardisTileEntity::new), //9
    CUSHING_EXTERIOR("cushing_exterior", TardisTileEntity::new), //10
    CLASSIC_EXTERIOR("classic_exterior", TardisTileEntity::new), //11
    HARTNELL_EXTERIOR("hartnell_exterior", TardisTileEntity::new), //12
    HUDOLIN_EXTERIOR("hudolin_exterior", TardisTileEntity::new), //13
    TX3_EXTERIOR("tx3_exterior", TardisTileEntity::new), //14
    TARDIM_EXTERIOR("tardim_exterior", TardisTileEntity::new), //15
    SHALKA_EXTERIOR("shalka_exterior", TardisTileEntity::new), //16
    BOOTH_EXTERIOR("booth_exterior", TardisTileEntity::new), //17
    STEVE_EXTERIOR("steve_exterior", TardisTileEntity::new), //18
    FALLOUT_SHELTER_EXTERIOR("fallout_shelter_exterior", TardisTileEntity::new), //19
    RANI_EXTERIOR("rani_exterior", TardisTileEntity::new), //20
    CLOCK_EXTERIOR("clock_exterior", TardisTileEntity::new); //21

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