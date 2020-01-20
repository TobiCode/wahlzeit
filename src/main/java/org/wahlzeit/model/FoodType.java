package org.wahlzeit.model;

import java.util.Objects;

public class FoodType {

    public String typeName;
    public FoodType parentFoodType;

    public FoodType(String typeName) {
        this.typeName = typeName;
    }

    public boolean isSubType(String typeName) {
        FoodType foodType = this.getParentFoodType();
        while (foodType != null) {
            if (foodType.getTypeName().equals(typeName)) {
                return true;
            }
            foodType = foodType.getParentFoodType();
        }
        return false;
    }

    public FoodType getParentFoodType() {
        return parentFoodType;
    }

    public void setParentFoodType(FoodType parentFoodType) {
        this.parentFoodType = parentFoodType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodType foodType = (FoodType) o;
        return Objects.equals(typeName, foodType.typeName) &&
                Objects.equals(parentFoodType, foodType.parentFoodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName, parentFoodType);
    }
}
