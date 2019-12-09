package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    @Test(expected = ArithmeticException.class)
    public void compareDoublesTest() {
        CartesianCoordinate.compareDoubles(Math.sqrt(-1), 1);
    }

    @Test(expected = java.lang.Exception.class)
    public void asSphericCoordinateTestWithUnvalidObjectState() throws Exception {
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getOrCreateCoordinate(Math.sqrt(-1), 1, 1);
        cartesianCoordinate.asSphericCoordinate();
    }

    @Test
    public void asSphericCoordinateTest() throws Exception {
        //https://matheplanet.com/default3.html?call=viewtopic.php?topic=151004&ref=https%3A%2F%2Fwww.google.com%2F
        CartesianCoordinate cartesianCoordinate =  CartesianCoordinate.getOrCreateCoordinate(1, 1, 1);

        SphericCoordinate sphericCoordinate = cartesianCoordinate.asSphericCoordinate();

        assertEquals(45, Math.toDegrees(sphericCoordinate.getPhi()), 0.001);
        assertEquals(54.7356, Math.toDegrees(sphericCoordinate.getTheta()), 0.001);
        assertEquals(Math.sqrt(3), sphericCoordinate.getRadius(), 0.001);
    }

    @Test
    public void getDistanceTest() throws Exception {
        CartesianCoordinate coordinate1 =  CartesianCoordinate.getOrCreateCoordinate(1, 1, 1);
        CartesianCoordinate coordinate2 =  CartesianCoordinate.getOrCreateCoordinate(3, 3, 3);

        double distance = coordinate1.getCartesianDistance(coordinate2);
        double expectedDistance = Math.sqrt(12.0);
        assertEquals(expectedDistance, distance, 0.0);
    }

    @Test
    public void isNotEqualTest() throws Exception {
        CartesianCoordinate coordinate1 =  CartesianCoordinate.getOrCreateCoordinate(1, 1, 1);
        CartesianCoordinate coordinate2 =  CartesianCoordinate.getOrCreateCoordinate(3, 3, 3);
        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test
    public void isEqualTest() throws Exception {
        CartesianCoordinate coordinate1 =  CartesianCoordinate.getOrCreateCoordinate(1, 1, 1);
        CartesianCoordinate coordinate2 =  CartesianCoordinate.getOrCreateCoordinate(1, 1, 1);
        assertTrue(coordinate1.equals(coordinate2));
    }

}