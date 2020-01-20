package org.wahlzeit.model;

import java.util.ArrayList;

public class Food {

    public boolean vegetarian;
    public boolean vegan;
    public EatingCourse possibleEatingCourse;
    FoodType foodtype;
    String name;
    ArrayList<String> ingredients;
    int caloriesRounded;

    public Food(String name) {
        this.name = name;
    }

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
