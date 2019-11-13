package org.wahlzeit.model;

import java.util.Objects;

public class CoordinateDeprecated {

    private static final double PRECISION = 0.0001;
    private final double x;
    private final double y;
    private final double z;

    public CoordinateDeprecated(double x, double y, double z) {
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

    public double getDistance(CoordinateDeprecated otherCoordinateDeprecated) {
        //direct Cartesian distance
        double distance = Math.sqrt(Math.pow(otherCoordinateDeprecated.x - this.x, 2) + Math.pow(otherCoordinateDeprecated.y - this.y, 2)
                + Math.pow(otherCoordinateDeprecated.z - this.z, 2));
        return distance;
    }

    public boolean isEqual(CoordinateDeprecated otherCoordinateDeprecated) {
        boolean isXEqual = compareDoubles(this.x, otherCoordinateDeprecated.getX());
        boolean isYEqual = compareDoubles(this.y, otherCoordinateDeprecated.getY());
        boolean isZEqual = compareDoubles(this.z, otherCoordinateDeprecated.getZ());

        return isXEqual && isYEqual && isZEqual;
    }

    @Override
    public boolean equals(Object otherCoordinate) {
        if (otherCoordinate instanceof CoordinateDeprecated) {
            return isEqual((CoordinateDeprecated) otherCoordinate);
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
