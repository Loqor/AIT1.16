package com.mdt.ait.core.init.enums;

import com.mdt.ait.common.tileentities.BasicInteriorDoorTile;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumInteriorDoorType implements IStringSerializable {

    DOOR_BASIC_BOX("door_basic_box", BasicInteriorDoorTile::new),
    //DOOR_MINT_BOX("door_mint_box", BasicInteriorDoorTile::new),
    //DOOR_CORAL_BOX("door_coral_box",BasicInteriorDoorTile::new),
    //DOOR_POSTER_BOX("door_poster_box", BasicInteriorDoorTile::new),
    //DOOR_BAKER_BOX("door_baker_box", BasicInteriorDoorTile::new),
    //DOOR_TYPE_40_TT_CAPSULE("door_type_40_tt_capsule", BasicInteriorDoorTile::new),
    //DOOR_HELLBENT_TT_CAPSULE("door_hellbent_tt_capsule", BasicInteriorDoorTile::new),
    //DOOR_NUKA_COLA_EXTERIOR("door_nuka_cola_exterior", BasicInteriorDoorTile::new),
    //DOOR_SIEGE_MODE("door_siege_mode", BasicInteriorDoorTile::new),
    //DOOR_ARCADE_CABINET_EXTERIOR("door_arcade_cabinet_exterior", BasicInteriorDoorTile::new),
    //DOOR_CUSHING_EXTERIOR("door_cushing_exterior", BasicInteriorDoorTile::new),
    DOOR_CLASSIC_EXTERIOR("door_classic_exterior", BasicInteriorDoorTile::new),
    //DOOR_HARTNELL_EXTERIOR("door_hartnell_exterior", BasicInteriorDoorTile::new),
    DOOR_HUDOLIN_EXTERIOR("door_hudolin_exterior", BasicInteriorDoorTile::new),
    //DOOR_TX3_EXTERIOR("door_tx3_exterior", BasicInteriorDoorTile::new),
    DOOR_TARDIM_EXTERIOR("door_tardim_exterior", BasicInteriorDoorTile::new),
    //DOOR_SHALKA_EXTERIOR("door_shalka_exterior", BasicInteriorDoorTile::new),
    //DOOR_BOOTH_EXTERIOR("door_booth_exterior", BasicInteriorDoorTile::new),
    //DOOR_STEVE_EXTERIOR("door_steve_exterior", BasicInteriorDoorTile::new),
    DOOR_FALLOUT_SHELTER_EXTERIOR("door_fallout_shelter_exterior", BasicInteriorDoorTile::new);
    //DOOR_RANI_EXTERIOR("door_rani_exterior", BasicInteriorDoorTile::new),
    //DOOR_CLOCK_EXTERIOR("door_clock_exterior", BasicInteriorDoorTile::new);

    public final Supplier<BasicInteriorDoorTile> tileEntity;
    public final String name;

    EnumInteriorDoorType(String _name, Supplier<BasicInteriorDoorTile> _te) {
        tileEntity = _te;
        name = _name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}