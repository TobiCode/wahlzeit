package org.wahlzeit.model;

import org.wahlzeit.Exceptions.CoordinateException;

import java.util.HashMap;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {


    private static HashMap<Integer, CartesianCoordinate> existingCoordinates = new HashMap<>();
    //Attributes final t ensure immutability of Value Object
    private final double x;
    private final double y;
    private final double z;

    private CartesianCoordinate(double x, double y, double z) throws CoordinateException {
        this.x = x;
        this.y = y;
        this.z = z;
        this.assertClassInvariants();
    }

    public static CartesianCoordinate getOrCreateCoordinate(double x, double y, double z) {
        try {
            CartesianCoordinate newCartesianCoordinate = new CartesianCoordinate(x, y, z);
            Integer hashCode = (Integer) newCartesianCoordinate.hashCode();
            synchronized (existingCoordinates) {
                CartesianCoordinate cartesianCoordinate = existingCoordinates.get(hashCode);
                if (cartesianCoordinate == null) {
                    existingCoordinates.put(newCartesianCoordinate.hashCode(), newCartesianCoordinate);
                    return newCartesianCoordinate;
                } else {
                    return cartesianCoordinate;
                }
            }
        } catch (CoordinateException e) {
            e.printStackTrace();
        }

        return null;
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
    public String toString() {
        return new StringBuilder().append("CartesianCoordinate with: \n")
                .append("X: " + this.x + "\n")
                .append("Y: " + this.y + "\n")
                .append("Z: " + this.z).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    protected void assertClassInvariants() throws CoordinateException {
        if (Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z)) {
            throw new CoordinateException("Values of Coordinate should not be NaN", this);
        }
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() throws CoordinateException {
        this.assertClassInvariants();
        double radius = Math.sqrt(x * x + y * y + z * z);
        double theta = Math.acos(z / radius);
        double phi = Math.atan2(y, x);
        SphericCoordinate sphericCoordinate = SphericCoordinate.getOrCreateCoordinate(phi, theta, radius);
        sphericCoordinate.assertClassInvariants();
        return sphericCoordinate;
    }

}
