package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test(expected = Exception.class)
    public void constructorTestRadiusMinus1() throws Exception {
        SphericCoordinate.getOrCreateCoordinate(30, 10, -10);
    }

    @Test(expected = Exception.class)
    public void constructorTestNaN() throws Exception {
        SphericCoordinate.getOrCreateCoordinate(Math.sqrt(-1), 10, -10);
    }

    @Test
    public void isEqualTest() throws Exception {
        SphericCoordinate sphericCoordinate = SphericCoordinate.getOrCreateCoordinate(30, 70, 3.5);
        SphericCoordinate sphericCoordinate1 = SphericCoordinate.getOrCreateCoordinate(30, 70, 3.5);
        assertTrue(sphericCoordinate.isEqual(sphericCoordinate1));
    }

    @Test
    public void isNotEqualTest() throws Exception {
        SphericCoordinate sphericCoordinate = SphericCoordinate.getOrCreateCoordinate(30, 70, 3.5);
        SphericCoordinate sphericCoordinate1 = SphericCoordinate.getOrCreateCoordinate(20, 70, 3.0);
        assertFalse(sphericCoordinate.isEqual(sphericCoordinate1));
    }

    @Test
    public void getCentralAngleTest() throws Exception {
        //https://de.wikipedia.org/wiki/Orthodrome
        SphericCoordinate sphericCoordinate = SphericCoordinate.getOrCreateCoordinate(52.517, 13.4, 3.5);
        SphericCoordinate sphericCoordinate1 = SphericCoordinate.getOrCreateCoordinate(35.7, 139.767, 3.5);
        double centralAngle = sphericCoordinate.getCentralAngle(sphericCoordinate1);

        double expectedCentralAngle = 80.2100;

        assertEquals(expectedCentralAngle, centralAngle, 0.001);
    }

    @Test
    public void asCartesianCoordinateTest() throws Exception {
        //https://matheplanet.com/default3.html?call=viewtopic.php?topic=151004&ref=https%3A%2F%2Fwww.google.com%2F
        SphericCoordinate sphericCoordinate = SphericCoordinate.getOrCreateCoordinate(45, 54.73, Math.sqrt(3));

        CartesianCoordinate cartesianCoordinate = sphericCoordinate.asCartesianCoordinate();

        assertEquals(1, cartesianCoordinate.getX(), 0.001);
        assertEquals(1, cartesianCoordinate.getY(), 0.001);
        assertEquals(1, cartesianCoordinate.getZ(), 0.001);
    }

}