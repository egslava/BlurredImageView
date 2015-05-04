package ru.egslava.blurredview;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import java.security.InvalidParameterException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public BlurredImageView blurredImageView;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();
        blurredImageView = new BlurredImageView(getContext());
    }


    @SmallTest public void testRadius() {
        blurredImageView.setRadius(0);
        blurredImageView.setRadius(1);
        blurredImageView.setRadius(0.5f);
        assertEquals(blurredImageView.radius, 0.5f);
    }

    @SmallTest public void testRadiusException() {
        try {
            blurredImageView.setRadius(1.1f);
            fail( "Invalid radius range is allowed" );
        } catch (InvalidParameterException e) {
            assertTrue(true);
        }
    }
}