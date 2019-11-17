package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate implements  Coordinate {

    private static final double PRECISION = 0.0001;
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

    @Override
    public boolean isEqual(Coordinate other) {
        boolean isRadiusEqual = compareDoubles(this.radius, other.asSphericCoordinate().getRadius());
        boolean isPhiEqual = compareDoubles(this.phi, other.asSphericCoordinate().getPhi());
        boolean isThetaEqual = compareDoubles(this.theta, other.asSphericCoordinate().getTheta());
        if(isRadiusEqual && this.radius == 0){
            return true;
        }
        return isRadiusEqual && isPhiEqual && isThetaEqual;
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
        return Objects.hash(radius, phi, theta);
    }

    private boolean compareDoubles(double firstDouble, double secondDouble) {
        if (Double.isNaN(firstDouble) || Double.isNaN(secondDouble)) {
            return false;
        }
        return Math.abs(firstDouble - secondDouble) < PRECISION;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(Math.toRadians(theta)) * Math.cos(Math.toRadians(phi));
        double y = radius * Math.sin(Math.toRadians(theta)) * Math.sin(Math.toRadians(phi));
        double z = radius * Math.cos(Math.toRadians(theta));
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        return cartesianCoordinate;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate otherSpheric = coordinate.asSphericCoordinate();
        double zeta = Math.toDegrees(Math.acos((Math.sin(Math.toRadians(phi))*
                Math.sin(Math.toRadians(otherSpheric.getPhi())) + Math.cos(Math.toRadians(phi)) *
                Math.cos(Math.toRadians(otherSpheric.getPhi())) *
                Math.cos(Math.toRadians(otherSpheric.getTheta()) - Math.toRadians(theta)))));
        return zeta;
    }

}
