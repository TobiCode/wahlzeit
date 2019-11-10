package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

import java.util.logging.Logger;


/**
 * A photo manager provides access to and manages photos.
 */
public class FoodPhotoManager extends PhotoManager {

//    instance = new FoodPhotoManager();

    private static final Logger log = Logger.getLogger(FoodPhotoManager.class.getName());

    public FoodPhotoManager() {

    }

    @Override
    public Photo getPhotoFromId(PhotoId id) {
        if (id == null) {
            return null;
        }

        Photo result = doGetPhotoFromId(id);

        if (result == null) {
            result = FoodPhotoFactory.getInstance().loadPhoto(id);
            if (result != null) {
                doAddPhoto(result);
            }
        }

        return result;
    }

    //TODO:Think about the desing, does it make sense?
    //Not sure if I need this Method or If I can handle it differently
    public Photo createPhoto(String filename, Image uploadedImage) throws Exception {
        PhotoId id = PhotoId.getNextId();
        Photo result = PhotoUtil.createFoodPhoto(filename, id, uploadedImage);
        addPhoto(result);
        return result;
    }


}
