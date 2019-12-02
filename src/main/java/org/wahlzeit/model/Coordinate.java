package org.wahlzeit.model;

import org.wahlzeit.Exceptions.CoordinateException;

public interface Coordinate {

    CartesianCoordinate asCartesianCoordinate() throws CoordinateException;

    double getCartesianDistance(Coordinate coordinate) throws CoordinateException;

    SphericCoordinate asSphericCoordinate() throws CoordinateException;

    double getCentralAngle(Coordinate coordinate) throws CoordinateException;

    boolean isEqual(Coordinate other) throws Exception;

}
