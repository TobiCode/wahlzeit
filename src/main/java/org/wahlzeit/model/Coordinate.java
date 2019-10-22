package org.wahlzeit.model;

public class Coordinate {

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
        if (otherCoordinate.x == this.x && otherCoordinate.y == this.y && otherCoordinate.z == this.z) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object otherCoordinate) {
        if (otherCoordinate instanceof Coordinate) {
            return isEqual((Coordinate) otherCoordinate);
        }
        return false;
    }
}
