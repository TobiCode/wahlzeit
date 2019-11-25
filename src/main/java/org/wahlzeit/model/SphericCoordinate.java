package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private final double phi;
    private final double theta;
    private final double radius;

    public SphericCoordinate(double phi, double theta, double radius) throws Exception {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        this.assertClassInvariants();
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

    public boolean isEqual(Coordinate other) throws Exception {
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
    public int hashCode() {
        return Objects.hash(radius, phi, theta);
    }

    @Override
    protected void assertClassInvariants() throws Exception {
        if (radius < 0) {
            throw new Exception("Class invariant not met.");
        }
        if (Double.isNaN(radius) || Double.isNaN(theta) || Double.isNaN(radius)) {
            throw new Exception("Class invariant not met.");
        }
    }

    public CartesianCoordinate asCartesianCoordinate() throws Exception {
        this.assertClassInvariants();
        double x = radius * Math.sin(Math.toRadians(theta)) * Math.cos(Math.toRadians(phi));
        double y = radius * Math.sin(Math.toRadians(theta)) * Math.sin(Math.toRadians(phi));
        double z = radius * Math.cos(Math.toRadians(theta));
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        cartesianCoordinate.assertClassInvariants();
        return cartesianCoordinate;
    }

    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

}
