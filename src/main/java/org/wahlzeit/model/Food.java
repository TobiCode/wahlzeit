package org.wahlzeit.model;

import java.util.ArrayList;
/*
How is object created? Bottom Up Explanation how the object is created:
The Food object can be directly instantiated with its constructor. You just have to pass a name and a FoodType as
parameters for the constructor. I have not written a Manager Object for creating a Fodd Object, because in my opinion
it was not necessary.

The object creation described in the solution space:
1. Delegation of object creation: N/A
2. Selection of concrete class: on-the-spot
3. Configuration of class mapping: N/A
4. Instantiation of concrete class: in-code
5. Initialization of new object: default with constructor and the possibility to set attributes afterwards
    through various setters.
6. Building of object structure: default

 */
public class Food {

    public boolean vegetarian;
    public boolean vegan;
    public EatingCourse possibleEatingCourse;
    FoodType foodtype;
    String name;
    ArrayList<String> ingredients;
    int caloriesRounded;

    public Food(FoodType foodtype, String name) {
        this.foodtype = foodtype;
        this.name = name;
    }

    public FoodType getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(FoodType foodtype) {
        this.foodtype = foodtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCaloriesRounded() {
        return caloriesRounded;
    }

    public void setCaloriesRounded(int caloriesRounded) {
        this.caloriesRounded = caloriesRounded;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public EatingCourse getPossibleEatingCourse() {
        return possibleEatingCourse;
    }

    public void setPossibleEatingCourse(EatingCourse possibleEatingCourse) {
        this.possibleEatingCourse = possibleEatingCourse;
    }

    enum EatingCourse {
        STARTER,
        MAIN_COURSE,
        DESSERT,
        SNACK
    }
}
