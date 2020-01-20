package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FoodTypeTest {

    @Test
    public void testIsSubtypeSuccesfull(){
        //given
        FoodType foodType = new FoodType("All Food");
        FoodType germanFoodType = new FoodType("German Food");
        germanFoodType.setParentFoodType(foodType);
        FoodType bavarianFoodType = new FoodType("Bavarian Food");
        bavarianFoodType.setParentFoodType(germanFoodType);
        //when
        boolean subType = bavarianFoodType.isSubType("All Food");
        //then
        assertTrue(subType);
    }

    @Test
    public void testIsSubtypeWrong(){
        //given
        FoodType foodType = new FoodType("All Food");
        FoodType germanFoodType = new FoodType("German Food");
        germanFoodType.setParentFoodType(foodType);
        FoodType bavarianFoodType = new FoodType("Bavarian Food");
        bavarianFoodType.setParentFoodType(germanFoodType);
        //when
        boolean subType = bavarianFoodType.isSubType("Chinese Food");
        //then
        assertFalse(subType);
    }

}