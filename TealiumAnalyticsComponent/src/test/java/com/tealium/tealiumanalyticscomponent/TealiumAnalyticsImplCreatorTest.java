package com.tealium.tealiumanalyticscomponent;

import com.amazon.analytics.tealium.TealiumAnalytics;
import com.amazon.analytics.tealium.TealiumAnalyticsImplCreator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link TealiumAnalyticsImplCreator} class
 */
@RunWith(RobolectricTestRunner.class)
public class TealiumAnalyticsImplCreatorTest {

    private TealiumAnalyticsImplCreator mTealiumAnalyticsImplCreator;

    @Before
    public void setUp() {
        mTealiumAnalyticsImplCreator = new TealiumAnalyticsImplCreator();
    }

    @After
    public void tearDown() {
        mTealiumAnalyticsImplCreator = null;
    }

    @Test
    public void createImpl() {
        assertTrue("createImpl() should create a TealiumAnalyticsObject", mTealiumAnalyticsImplCreator.createImpl() instanceof TealiumAnalytics);
    }
}
