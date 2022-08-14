/*package com.mdt.ait.common.entities;

import com.mdt.ait.common.controls.AbstractConsoleInteractionControl;
import com.mdt.ait.common.entities.ControlInteractionEntity;
import com.mdt.ait.common.tileentities.ConsoleTileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class BaseConsoleInteractionControl extends AbstractConsoleInteractionControl {

    private ConsoleTileEntity console;
    private ControlInteractionEntity parent;

    public BaseConsoleInteractionControl(ConsoleTileEntity console, ControlInteractionEntity entity) {
        this.console = console;
        this.parent = entity;
    }

    @Override
    public ConsoleTileEntity getConsole() {
        return this.console;
    }

    @Override
    public Vector3d getPos() {
        return null;
    }

    @Override
    public void setConsole(ConsoleTileEntity console, ControlInteractionEntity entity) {
        this.console = console;
        this.parent = entity;
    }

    @Override
    public void onPacketUpdate() {

    }

    @Override
    public ControlInteractionEntity getEntity() {
        return this.parent;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {

    }
}*/
