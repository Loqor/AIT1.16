package com.mdt.ait.core.init.enums;

import io.mdt.ait.tardis.TARDISInteriorDoorTile;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumInteriorDoorType implements IStringSerializable {

    DOOR_BASIC_BOX("door_basic_exterior", TARDISInteriorDoorTile::new), //0
    DOOR_MINT_BOX("door_mint_exterior", TARDISInteriorDoorTile::new), //1
    DOOR_CORAL_BOX("door_coral_exterior",TARDISInteriorDoorTile::new), //2
    DOOR_POSTER_BOX("door_poster_exterior", TARDISInteriorDoorTile::new), //3
    DOOR_BAKER_BOX("door_baker_exterior", TARDISInteriorDoorTile::new), //4
    DOOR_TYPE_40_TT_CAPSULE("door_type_40_tt_capsule", TARDISInteriorDoorTile::new), //5
    DOOR_HELLBENT_TT_CAPSULE("door_hellbent_tt_capsule", TARDISInteriorDoorTile::new), //6
    DOOR_NUKA_COLA_EXTERIOR("door_nuka_cola_exterior", TARDISInteriorDoorTile::new),  //7
    DOOR_SIEGE_MODE("door_siege_mode", TARDISInteriorDoorTile::new), //8
    DOOR_ARCADE_CABINET_EXTERIOR("door_arcade_cabinet_exterior", TARDISInteriorDoorTile::new), //9
    DOOR_CUSHING_EXTERIOR("door_cushing_exterior", TARDISInteriorDoorTile::new), //10
    DOOR_CLASSIC_EXTERIOR("door_classic_exterior", TARDISInteriorDoorTile::new), //11
    DOOR_HARTNELL_EXTERIOR("door_hartnell_exterior", TARDISInteriorDoorTile::new), //12
    DOOR_HUDOLIN_EXTERIOR("door_hudolin_exterior", TARDISInteriorDoorTile::new), //13
    DOOR_TX3_EXTERIOR("door_tx3_exterior", TARDISInteriorDoorTile::new), //14
    DOOR_TARDIM_EXTERIOR("door_tardim_exterior", TARDISInteriorDoorTile::new), //15
    DOOR_SHALKA_EXTERIOR("door_shalka_exterior", TARDISInteriorDoorTile::new), //16
    DOOR_BOOTH_EXTERIOR("door_booth_exterior", TARDISInteriorDoorTile::new), //17
    DOOR_STEVE_EXTERIOR("door_steve_exterior", TARDISInteriorDoorTile::new), //18
    DOOR_FALLOUT_SHELTER_EXTERIOR("door_fallout_shelter_exterior", TARDISInteriorDoorTile::new), //19
    DOOR_RANI_EXTERIOR("door_rani_exterior", TARDISInteriorDoorTile::new), //20
    DOOR_CLOCK_EXTERIOR("door_clock_exterior", TARDISInteriorDoorTile::new); //21

    public final Supplier<TARDISInteriorDoorTile> tileEntity;
    public final String name;

    EnumInteriorDoorType(String _name, Supplier<TARDISInteriorDoorTile> _te) {
        tileEntity = _te;
        name = _name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}