package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateDeprecatedTest {

    @Test
    public void getDistanceTest(){
        CoordinateDeprecated coordinateDeprecated1 = new CoordinateDeprecated(1,1,1);
        CoordinateDeprecated coordinateDeprecated2 = new CoordinateDeprecated(3,3,3);

        double distance = coordinateDeprecated1.getDistance(coordinateDeprecated2);
        double expectedDistance = Math.sqrt(12.0);
        assertEquals(expectedDistance, distance, 0.0);
    }

    @Test
    public void isNotEqualTest(){
        CoordinateDeprecated coordinateDeprecated1 = new CoordinateDeprecated(1,1,1);
        CoordinateDeprecated coordinateDeprecated2 = new CoordinateDeprecated(3,3,3);
        assertFalse(coordinateDeprecated1.equals(coordinateDeprecated2));
    }

    @Test
    public void isEqualTest(){
        CoordinateDeprecated coordinateDeprecated1 = new CoordinateDeprecated(1,1,1);
        CoordinateDeprecated coordinateDeprecated2 = new CoordinateDeprecated(1,1,1);
        assertTrue(coordinateDeprecated1.equals(coordinateDeprecated2));
    }

}