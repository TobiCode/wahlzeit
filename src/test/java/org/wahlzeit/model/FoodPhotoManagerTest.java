package org.wahlzeit.model;

import com.google.appengine.api.images.Image;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.mockito.Mockito;
import org.wahlzeit.testEnvironmentProvider.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FoodPhotoManagerTest {

    @ClassRule
    public static SysConfigProvider sysConfigProvider = new SysConfigProvider();
    @ClassRule
    public static WebFormHandlerProvider webFormHandlerProvider = new WebFormHandlerProvider();

    @Rule
    public TestRule chain = RuleChain.
            outerRule(new LocalDatastoreServiceTestConfigProvider()).
            around(new RegisteredOfyEnvironmentProvider()).
            around(new UserSessionProvider());

    @Test
    public void getInstanceTest() throws Exception {
        //Verifies that only the FoodPhotoManager is used.
        FoodPhotoManager instance =  FoodPhotoManager.getInstance();
        FoodPhotoManager instance2 = PhotoManager.getInstance();
//
//        //when
//        Image imageMock = Mockito.mock(Image.class);
//        when(imageMock.getHeight()).thenReturn(420);
//        when(imageMock.getWidth()).thenReturn(420);
//        byte b = anyByte();
//        when(imageMock.getImageData()).thenReturn(b);
//        instance.createPhoto("test", imageMock);
//        //then
//        verify(PhotoUtil.createFoodPhoto(any(), any(), any()));
//        verify(PhotoUtil.createPhoto(any(), any(), any()));
    }

}