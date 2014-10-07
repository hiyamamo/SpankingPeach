package com.example.spankingpeach;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


/**
 * Created by hiroki on 2014/10/01.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class SampleTest {
    @Before
    public void setup() {
        // setup
    }

    @After
    public void teardown() {
        // teardown
    }

    @Test
    public void sampleTest() {
        Assert.assertTrue("assert",true);
    }
}
