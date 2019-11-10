package org.wahlzeit.model;

public class FoodPhoto extends Photo {

    private String originOfTheFood;
    private String nameOfTheFood;
    private boolean isSpicy;
    private double calories;

    public FoodPhoto() {
        super();
    }

    public FoodPhoto(PhotoId myId) {
        super(myId);
    }


    public String getOriginOfTheFood() {
        return originOfTheFood;
    }

    public void setOriginOfTheFood(String originOfTheFood) {
        this.originOfTheFood = originOfTheFood;
    }

    public String getNameOfTheFood() {
        return nameOfTheFood;
    }

    public void setNameOfTheFood(String nameOfTheFood) {
        this.nameOfTheFood = nameOfTheFood;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}