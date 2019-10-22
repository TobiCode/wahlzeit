package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void getDistanceTest(){
        Coordinate coordinate1 = new Coordinate(1,1,1);
        Coordinate coordinate2 = new Coordinate(3,3,3);

        double distance = coordinate1.getDistance(coordinate2);
        double expectedDistance = Math.sqrt(12.0);
        assertEquals(expectedDistance, distance, 0.0);
    }

    @Test
    public void isNotEqualTest(){
        Coordinate coordinate1 = new Coordinate(1,1,1);
        Coordinate coordinate2 = new Coordinate(3,3,3);
        assertFalse(coordinate1.equals(coordinate2));
    }

    @Test
    public void isEqualTest(){
        Coordinate coordinate1 = new Coordinate(1,1,1);
        Coordinate coordinate2 = new Coordinate(1,1,1);
        assertTrue(coordinate1.equals(coordinate2));
    }

}