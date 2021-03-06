package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.TellFriendTest;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;
import org.wahlzeit.services.mailing.EmailServiceTest;
import org.wahlzeit.utils.StringUtilTest;
import org.wahlzeit.utils.VersionTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({TellFriendTest.class,  DatastoreAdapterTest.class, AccessRightsTest.class,
        CoordinateDeprecatedTest.class, FlagReasonTest.class, GenderTest.class, GuestTest.class, PhotoFilterTest.class,
TagsTest.class, UserStatusTest.class, ValueTest.class, EmailServiceTest.class, EmailAddressTest.class,
        LogBuilderTest.class, StringUtilTest.class, VersionTest.class, SphericCoordinateTest.class,
        CartesianCoordinateTest.class})
public class AllTests {
}
