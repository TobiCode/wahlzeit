package org.wahlzeit.model;


public class Location {

    private Coordinate coordinate;

    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("Nicht zulässig, da eine Location immer genau 1 " +
                    "Coordinate nach dem UML Diagramm hat");
        }
        this.coordinate = coordinate;
    }
}
