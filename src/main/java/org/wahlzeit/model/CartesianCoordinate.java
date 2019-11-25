package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    public CartesianCoordinate(double x, double y, double z) throws Exception {
        this.x = x;
        this.y = y;
        this.z = z;
        this.assertClassInvariants();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public boolean isEqual(Coordinate other) throws Exception {
        boolean isXEqual = compareDoubles(this.x, other.asCartesianCoordinate().getX());
        boolean isYEqual = compareDoubles(this.y, other.asCartesianCoordinate().getY());
        boolean isZEqual = compareDoubles(this.z, other.asCartesianCoordinate().getZ());

        return isXEqual && isYEqual && isZEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    protected void assertClassInvariants() throws Exception {
        if(Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z)){
            throw new Exception("Class invariant not met.");
        }
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() throws Exception {
        this.assertClassInvariants();
        double radius = Math.sqrt(x * x + y * y + z * z);
        double theta = Math.acos(z / radius);
        double phi = Math.atan2(y, x);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        sphericCoordinate.assertClassInvariants();
        return sphericCoordinate;
    }

}