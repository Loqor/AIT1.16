package io.mdt.ait.tardis;

public class PortalInfo {

    private final double width;
    private final double height;
    private final double x;
    private final double y;
    private final double z;

    public PortalInfo(double width, double height, double x, double y, double z) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double width() {
        return this.width;
    }

    public double height() {
        return this.height;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }
}
