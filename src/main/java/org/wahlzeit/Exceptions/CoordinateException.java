package org.wahlzeit.Exceptions;

import org.wahlzeit.model.Coordinate;

public class CoordinateException extends Exception {

    String description;
    Coordinate coordinate;

    public CoordinateException( String description, Coordinate coordinate ) {
        super(description);
        this.description = description;
        this.coordinate = coordinate;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CoordinateException" + "\n");
        stringBuilder.append("Description: "+ description + "\n");
        stringBuilder.append("Coordinate Object: " + coordinate.toString() + "\n");
        return stringBuilder.toString();
    }
}
