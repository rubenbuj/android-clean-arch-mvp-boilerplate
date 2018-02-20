package com.altv.dugoutapp;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UtilsUnitTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Context context;
    @Mock
    Resources resources;
    @Mock
    Configuration configuration;

    @Test
    public void isTablet() throws Exception {
        Mockito.when(context.getResources()).thenReturn(resources);
        Mockito.when(resources.getConfiguration()).thenReturn(configuration);

        configuration.screenLayout = Configuration.SCREENLAYOUT_SIZE_NORMAL;
        Assert.assertFalse(Utils.isTablet(context));
        configuration.screenLayout = Configuration.SCREENLAYOUT_SIZE_LARGE;
        Assert.assertTrue(Utils.isTablet(context)==true);
        configuration.screenLayout = Configuration.SCREENLAYOUT_SIZE_XLARGE;
        Assert.assertTrue(Utils.isTablet(context)==true);
    }
}