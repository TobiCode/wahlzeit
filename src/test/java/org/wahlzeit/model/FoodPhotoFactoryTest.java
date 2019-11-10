package org.wahlzeit.model;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.*;

import static org.junit.Assert.*;

public class FoodPhotoFactoryTest {


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
    public void getInstanceTest(){
        FoodPhotoFactory instance = FoodPhotoFactory.getInstance();
    }

    @Test
    public void createPhotoTest(){
        PhotoId id = PhotoId.getNextId();
        FoodPhoto photo = FoodPhotoFactory.getInstance().createPhoto(id);
    }

}