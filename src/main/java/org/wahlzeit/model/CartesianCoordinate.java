package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate implements Coordinate {

    private static final double PRECISION = 0.0001;
    private final double x;
    private final double y;
    private final double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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


    @Override
    public boolean isEqual(Coordinate other) {
        boolean isXEqual = compareDoubles(this.x, other.asCartesianCoordinate().getX());
        boolean isYEqual = compareDoubles(this.y, other.asCartesianCoordinate().getY());
        boolean isZEqual = compareDoubles(this.z, other.asCartesianCoordinate().getZ());

        return isXEqual && isYEqual && isZEqual;
    }

    @Override
    public boolean equals(Object otherCoordinate) {
        if (otherCoordinate instanceof Coordinate) {
            return isEqual((Coordinate) otherCoordinate);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    private boolean compareDoubles(double firstDouble, double secondDouble) {
        if (Double.isNaN(firstDouble) || Double.isNaN(secondDouble)) {
            return false;
        }
        return Math.abs(firstDouble - secondDouble) < PRECISION;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        //direct Cartesian distance
        double distance = Math.sqrt(Math.pow(coordinate.asCartesianCoordinate().x - this.x, 2) +
                Math.pow(coordinate.asCartesianCoordinate().y - this.y, 2)
                + Math.pow(coordinate.asCartesianCoordinate().z - this.z, 2));
        return distance;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(x*x + y*y + z*z);
        double theta = Math.acos(z / radius);
        double phi = Math.atan2(y, x);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        return sphericCoordinate;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return this.asSphericCoordinate().getCentralAngle(coordinate.asSphericCoordinate());
    }

}
