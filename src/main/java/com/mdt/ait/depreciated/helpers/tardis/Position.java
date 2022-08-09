package com.mdt.ait.depreciated.helpers.tardis;

import net.minecraft.dispenser.IPosition;

import java.io.Serializable;

public class Position implements Serializable, IPosition {

    private static final long serialVersionUID = 5003712931359763244L;
    private double xPos;
    private double yPos;
    private double zPos;

    public Position(final double x, final double y, final double z) {
        this.xPos = x;
        this.yPos = y;
        this.zPos = z;
    }

    @Override
    public double x() {
        return this.xPos;
    }

    @Override
    public double y() {
        return this.yPos;
    }

    @Override
    public double z() {
        return this.zPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public void setzPos(double zPos) {
        this.zPos = zPos;
    }
}
