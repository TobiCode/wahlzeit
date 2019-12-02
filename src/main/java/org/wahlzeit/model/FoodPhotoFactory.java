package org.wahlzeit.model;

import org.wahlzeit.Exceptions.CoordinateException;
import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class FoodPhotoFactory extends PhotoFactory {


    private static final Logger log = Logger.getLogger(FoodPhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static FoodPhotoFactory instance = null;

    private FoodPhotoFactory() {
        // do nothing
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     */
    public static synchronized FoodPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting FoodPhotoFactory").toString());
            setInstance(new FoodPhotoFactory());
        }

        return instance;
    }

    protected static synchronized void setInstance(FoodPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize FoogPhotoFactory twice");
        }

        instance = photoFactory;
    }

    /**
     * @methodtype factory
     */
    @Override
    public FoodPhoto createPhoto() {
        return new FoodPhoto();
    }

    public FoodPhoto createPhoto(double x, double y, double z) throws CoordinateException {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        FoodPhoto foodPhoto = new FoodPhoto();
        Location location = new Location(cartesianCoordinate);
        location.setCoordinate(cartesianCoordinate);
        foodPhoto.setLocation(location);
        return foodPhoto;
    }

    /**
     * Creates a new photo with the specified id
     */
    @Override
    public FoodPhoto createPhoto(PhotoId id) {
        return new FoodPhoto(id);
    }

    @Override
    public FoodPhoto loadPhoto(PhotoId id) {
	   /* Photo result =
                OfyService.ofy().load().type(Photo.class).ancestor(KeyFactory.createKey("Application", "Wahlzeit")).filter(Photo.ID, id).first().now();
        for (PhotoSize size : PhotoSize.values()) {
            GcsFilename gcsFilename = new GcsFilename("picturebucket", filename);

        }*/
        return null;
    }

}
