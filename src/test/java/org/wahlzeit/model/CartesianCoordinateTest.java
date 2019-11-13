package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    @Test
    public void asSphericCoordinateTest(){
        //https://matheplanet.com/default3.html?call=viewtopic.php?topic=151004&ref=https%3A%2F%2Fwww.google.com%2F
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(1, 1, 1);

        SphericCoordinate sphericCoordinate = cartesianCoordinate.asSphericCoordinate();

        assertEquals(45, Math.toDegrees(sphericCoordinate.getPhi()), 0.001);
        assertEquals(54.7356, Math.toDegrees(sphericCoordinate.getTheta()),0.001);
        assertEquals(Math.sqrt(3), sphericCoordinate.getRadius(), 0.001);
    }

    @Test
    public void getDistanceTest(){
        CartesianCoordinate coordinate1 = new CartesianCoordinate(1,1,1);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(3,3,3);

        double distance = coordinate1.getCartesianDistance(coordinate2);
        double expectedDistance = Math.sqrt(12.0);
        assertEquals(expectedDistance, distance, 0.0);
    }

    @Test
    public void isNotEqualTest(){
        CartesianCoordinate coordinate1 = new CartesianCoordinate(1,1,1);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(3,3,3);
        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test
    public void isEqualTest(){
        CartesianCoordinate coordinate1 = new CartesianCoordinate(1,1,1);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(1,1,1);
        assertTrue(coordinate1.equals(coordinate2));
    }

}