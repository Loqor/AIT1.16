package com.mdt.ait.core.init.enums;

import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum EnumConsoleType implements IStringSerializable {

    BOREALIS_CONSOLE("borealis_console", ConsoleTileEntity::new),
    HUDOLIN_CONSOLE("hudolin_console", ConsoleTileEntity::new),
    DEV_CONSOLE("dev_console", ConsoleTileEntity::new);

    public final Supplier<ConsoleTileEntity> tileEntity;
    public final String name;

    EnumConsoleType(String _name, Supplier<ConsoleTileEntity> _te) {
        tileEntity = _te;
        name = _name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}