package org.wahlzeit.model;

import org.wahlzeit.utils.DesignPatternInstance;

/*
How is the object created? Bottom Up Explanation how the object is created:
1) The Object is initialized by the FoodPhotoFactory with the method createPhoto().
2) The method from 1 is called within the PhotoUtil Class within the createFoodPhoto Method. After creating the
    Photo, it also sets the width and height of the photo accordingly.
3) The method from 2 is called by the FoodPhotoManager within the createPhoto Method. Within the createPhoto Method,
    the Photo is also added to the photoCache with the addPhoto Method.
4) The method from 3 is called either within the class ModelMain (5.2) or within the class UploadPhotoFormHandler (5.1).
5.1) The class UploadPhotoFormHandler calls the method from 3 in its doHandlePost method. This method is called by
     the class AbstractWebFormHandler with the method handlePost, which is called in MainServlet.myPost.
     MainServlet.myPost is called by the AbstractServlet class within the method doPost. The UploadPhotoFormHandler
     is representing the logic behind the UploadPhotoForm.html form, with which the user can upload photos.
5.2) The class ModelMain calls the method from 3 in its createUser Method, which is called within either
     CreateUser.execute, SetUpFlower.execute or ServiceMain.addDefaultUserWithPictures. The addDefaultUserWithPictures
     Method is called within ServiceMain.startUp, which is called by Wahlzeit.contextInitialized. This logic is executed
     at the startUp of the application. A default user is created and some default photos are loaded.

The object creation described in the solution space:
1. Delegation of object creation: seperate object (FoodPhotoFactory).
2. Selection of concrete class: by subclassing (extends PhotoFactory).
3. Configuration of class mapping: in-code.
4. Instantiation of concrete class: in-code.
5. Initialization of new object: default in the beginning and setting some values afterwards.
6. Building of object structure: default/by-building. The object receives new fields through setters
    in the Method PhotoUtil.createFoodPhoto().
 */

@DesignPatternInstance(
        patternNames = {"Abstract Factory"},
        participants = {"ConcreteProduct"}
)
public class FoodPhoto extends Photo {

    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

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
