package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private final double phi;
    private final double theta;
    private final double radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
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

    public boolean isEqual(Coordinate other) {
        boolean isRadiusEqual = compareDoubles(this.radius, other.asSphericCoordinate().getRadius());
        boolean isPhiEqual = compareDoubles(this.phi, other.asSphericCoordinate().getPhi());
        boolean isThetaEqual = compareDoubles(this.theta, other.asSphericCoordinate().getTheta());
        if (isRadiusEqual && this.radius == 0) {
            return true;
        }
        return isRadiusEqual && isPhiEqual && isThetaEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, phi, theta);
    }

    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(Math.toRadians(theta)) * Math.cos(Math.toRadians(phi));
        double y = radius * Math.sin(Math.toRadians(theta)) * Math.sin(Math.toRadians(phi));
        double z = radius * Math.cos(Math.toRadians(theta));
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        return cartesianCoordinate;
    }

    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

}
