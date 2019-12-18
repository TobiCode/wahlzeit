package org.wahlzeit.model;

import org.wahlzeit.Exceptions.CoordinateException;
import org.wahlzeit.utils.DesignPatternInstance;

import java.util.HashMap;
import java.util.Objects;

@DesignPatternInstance(
        patternNames = "Template Method Pattern",
        participants = {"Concrete Class with hook methods"}
)
public class SphericCoordinate extends AbstractCoordinate {

    private static HashMap<Integer, SphericCoordinate> existingCoordinates = new HashMap<>();
    private final double phi;
    private final double theta;
    private final double radius;

    private SphericCoordinate(double phi, double theta, double radius) throws CoordinateException {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        this.assertClassInvariants();
    }

    public static SphericCoordinate getOrCreateCoordinate(double phi, double theta, double radius) throws CoordinateException {

        SphericCoordinate newSphericCoordinate = new SphericCoordinate(phi, theta, radius);
        Integer hashCode = (Integer) newSphericCoordinate.hashCode();
        synchronized (existingCoordinates) {
            SphericCoordinate existingCoordinate = existingCoordinates.get(hashCode);
            if (existingCoordinate == null) {
                existingCoordinates.put(newSphericCoordinate.hashCode(), newSphericCoordinate);
                return newSphericCoordinate;
            } else {
                return existingCoordinate;
            }
        }
    }

    public double getPhi() {
        return phi;
    }

    public double getTheta() {
        return theta;
    }

    public double getRadius() {
        return radius;
    }

    public boolean isEqual(Coordinate other) throws CoordinateException {
        other.asSphericCoordinate().assertClassInvariants();
        boolean isRadiusEqual = compareDoubles(this.radius, other.asSphericCoordinate().getRadius());
        boolean isPhiEqual = compareDoubles(this.phi, other.asSphericCoordinate().getPhi());
        boolean isThetaEqual = compareDoubles(this.theta, other.asSphericCoordinate().getTheta());
        if (isRadiusEqual && this.radius == 0) {
            return true;
        }
        return isRadiusEqual && isPhiEqual && isThetaEqual;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Spheric Coordinate with: \n")
                .append("Phi: " + this.phi + "\n")
                .append("Theta: " + this.theta + "\n")
                .append("Radius: " + this.radius).toString();
    }


    @Override
    public int hashCode() {
        return Objects.hash(radius, phi, theta);
    }

    @Override
    protected void assertClassInvariants() throws CoordinateException {
        if (radius < 0) {
            throw new CoordinateException("Radius should not be smaller than 0", this);
        }
        if (Double.isNaN(radius) || Double.isNaN(theta) || Double.isNaN(radius)) {
            throw new CoordinateException("Values of Coordinate should not be NaN", this);
        }
    }

    public CartesianCoordinate asCartesianCoordinate() throws CoordinateException {
        this.assertClassInvariants();
        double x = radius * Math.sin(Math.toRadians(theta)) * Math.cos(Math.toRadians(phi));
        double y = radius * Math.sin(Math.toRadians(theta)) * Math.sin(Math.toRadians(phi));
        double z = radius * Math.cos(Math.toRadians(theta));
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getOrCreateCoordinate(x, y, z);
        cartesianCoordinate.assertClassInvariants();
        return cartesianCoordinate;
    }

    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

}
