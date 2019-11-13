package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test
    public void isEqualTest() {
        SphericCoordinate sphericCoordinate = new SphericCoordinate(30, 70, 3.5);
        SphericCoordinate sphericCoordinate1 = new SphericCoordinate(30, 70, 3.5);
        assertTrue(sphericCoordinate.isEqual(sphericCoordinate1));
    }

    @Test
    public void isNotEqualTest() {
        SphericCoordinate sphericCoordinate = new SphericCoordinate(30, 70, 3.5);
        SphericCoordinate sphericCoordinate1 = new SphericCoordinate(20, 70, 3.0);
        assertFalse(sphericCoordinate.isEqual(sphericCoordinate1));
    }

    @Test
    public void getCentralAngleTest() {
        //https://de.wikipedia.org/wiki/Orthodrome
        SphericCoordinate sphericCoordinate = new SphericCoordinate(52.517, 13.4, 3.5);
        SphericCoordinate sphericCoordinate1 = new SphericCoordinate(35.7, 139.767, 3.5);
        double centralAngle = sphericCoordinate.getCentralAngle(sphericCoordinate1);

        double expectedCentralAngle = 80.2100;

        assertEquals(expectedCentralAngle, centralAngle, 0.001);
    }

    @Test
    public void asCartesianCoordinateTest() {
        //https://matheplanet.com/default3.html?call=viewtopic.php?topic=151004&ref=https%3A%2F%2Fwww.google.com%2F
        SphericCoordinate sphericCoordinate = new SphericCoordinate(45, 54.73, Math.sqrt(3));

        CartesianCoordinate cartesianCoordinate = sphericCoordinate.asCartesianCoordinate();

        assertEquals(1, cartesianCoordinate.getX(), 0.001);
        assertEquals(1, cartesianCoordinate.getY(),0.001);
        assertEquals(1, cartesianCoordinate.getZ(), 0.001);
    }

}