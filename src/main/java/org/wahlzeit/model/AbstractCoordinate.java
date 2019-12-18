package org.wahlzeit.model;

import org.wahlzeit.Exceptions.CoordinateException;
import org.wahlzeit.utils.DesignPatternInstance;

@DesignPatternInstance(
        patternNames = "Template Method Pattern",
        participants = {"AbstractClass with abstract methods"}
)
public abstract class AbstractCoordinate implements Coordinate {

    protected static final double PRECISION = 0.0001;

    protected static boolean compareDoubles(double firstDouble, double secondDouble) {
        //Precondition
        if (Double.isNaN(firstDouble) || Double.isNaN(secondDouble)) {
            throw new ArithmeticException("Double value should not be NaN if it is compared to another double!");
        }
        return Math.abs(firstDouble - secondDouble) < PRECISION;
    }

    protected abstract void assertClassInvariants() throws CoordinateException;

    public abstract CartesianCoordinate asCartesianCoordinate() throws CoordinateException;

    public double getCartesianDistance(Coordinate coordinate) throws CoordinateException {
        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        coordinate.asCartesianCoordinate().assertClassInvariants();
        cartesianCoordinate.assertClassInvariants();
        //direct Cartesian distance
        double distance = Math.sqrt(Math.pow(coordinate.asCartesianCoordinate().getX() - cartesianCoordinate.getX(), 2)
                + Math.pow(coordinate.asCartesianCoordinate().getY() - cartesianCoordinate.getY(), 2)
                + Math.pow(coordinate.asCartesianCoordinate().getZ() - cartesianCoordinate.getZ(), 2));
        return distance;
    }

    public abstract SphericCoordinate asSphericCoordinate() throws CoordinateException;

    public double getCentralAngle(Coordinate coordinate) throws CoordinateException {
        SphericCoordinate sphericCoordinate = this.asSphericCoordinate();
        SphericCoordinate otherSpheric = coordinate.asSphericCoordinate();
        sphericCoordinate.assertClassInvariants();
        otherSpheric.assertClassInvariants();
        double zeta = Math.toDegrees(Math.acos((Math.sin(Math.toRadians(sphericCoordinate.getPhi())) *
                Math.sin(Math.toRadians(otherSpheric.getPhi())) + Math.cos(Math.toRadians(sphericCoordinate.getPhi())) *
                Math.cos(Math.toRadians(otherSpheric.getPhi())) *
                Math.cos(Math.toRadians(otherSpheric.getTheta()) - Math.toRadians(sphericCoordinate.getTheta())))));
        return zeta;
    }

    @Override
    public boolean equals(Object otherCoordinate) {
        if (otherCoordinate instanceof Coordinate) {
            try {
                return isEqual((Coordinate) otherCoordinate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public abstract boolean isEqual(Coordinate other) throws Exception;

    public abstract String toString();
}
