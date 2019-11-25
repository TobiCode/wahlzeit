package org.wahlzeit.model;

public interface Coordinate {

    CartesianCoordinate asCartesianCoordinate() throws Exception;

    double getCartesianDistance(Coordinate coordinate) throws Exception;

    SphericCoordinate asSphericCoordinate() throws Exception;

    double getCentralAngle(Coordinate coordinate) throws Exception;

    boolean isEqual(Coordinate other) throws Exception;

}
