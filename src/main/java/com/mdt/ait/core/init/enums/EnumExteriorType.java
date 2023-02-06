package com.mdt.ait.core.init.enums;

import io.mdt.ait.common.tiles.TARDISTileEntity;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumExteriorType implements IStringSerializable {

    BASIC_BOX("basic_box", TARDISTileEntity::new), //0
    MINT_BOX("mint_box", TARDISTileEntity::new), //1
    CORAL_BOX("coral_box",TARDISTileEntity::new), //2
    POSTER_BOX("poster_box", TARDISTileEntity::new), //3
    BAKER_BOX("baker_box", TARDISTileEntity::new), //4
    TYPE_40_TT_CAPSULE("type_40_tt_capsule", TARDISTileEntity::new), //5
    HELLBENT_TT_CAPSULE("hellbent_tt_capsule", TARDISTileEntity::new), //6
    NUKA_COLA_EXTERIOR("nuka_cola_exterior", TARDISTileEntity::new), //7
    SIEGE_MODE("siege_mode", TARDISTileEntity::new), //8
    ARCADE_CABINET_EXTERIOR("arcade_cabinet_exterior", TARDISTileEntity::new), //9
    CUSHING_EXTERIOR("cushing_exterior", TARDISTileEntity::new), //10
    CLASSIC_EXTERIOR("classic_exterior", TARDISTileEntity::new), //11
    HARTNELL_EXTERIOR("hartnell_exterior", TARDISTileEntity::new), //12
    HUDOLIN_EXTERIOR("hudolin_exterior", TARDISTileEntity::new), //13
    TX3_EXTERIOR("tx3_exterior", TARDISTileEntity::new), //14
    TARDIM_EXTERIOR("tardim_exterior", TARDISTileEntity::new), //15
    SHALKA_EXTERIOR("shalka_exterior", TARDISTileEntity::new), //16
    BOOTH_EXTERIOR("booth_exterior", TARDISTileEntity::new), //17
    STEVE_EXTERIOR("steve_exterior", TARDISTileEntity::new), //18
    FALLOUT_SHELTER_EXTERIOR("fallout_shelter_exterior", TARDISTileEntity::new), //19
    RANI_EXTERIOR("rani_exterior", TARDISTileEntity::new), //20
    CLOCK_EXTERIOR("clock_exterior", TARDISTileEntity::new); //21

    public final Supplier<TARDISTileEntity> tileEntity;
    public final String name;

    EnumExteriorType(String _name, Supplier<TARDISTileEntity> _te) {
        tileEntity = _te;
        name = _name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}