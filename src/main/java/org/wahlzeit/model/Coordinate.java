package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

    private static final double PRECISION = 0.0001;
    private final double x;
    private final double y;
    private final double z;

    public Coordinate(double x, double y, double z) {
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

    public double getDistance(Coordinate otherCoordinate) {
        //direct Cartesian distance
        double distance = Math.sqrt(Math.pow(otherCoordinate.x - this.x, 2) + Math.pow(otherCoordinate.y - this.y, 2)
                + Math.pow(otherCoordinate.z - this.z, 2));
        return distance;
    }

    public boolean isEqual(Coordinate otherCoordinate) {
        boolean isXEqual = compareDoubles(this.x, otherCoordinate.getX());
        boolean isYEqual = compareDoubles(this.y, otherCoordinate.getY());
        boolean isZEqual = compareDoubles(this.z, otherCoordinate.getZ());

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
}
