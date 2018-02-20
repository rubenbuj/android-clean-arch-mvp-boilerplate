package com.altv.dugoutapp;

import com.altv.dugoutapp.trending_list.TrendingListView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by rubenbujalance on 07/02/2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = TestUtils.initRobolectricMainActivity();
    }

    @Test
    public void testStart() throws Exception {
        Assert.assertNotNull(mainActivity);
        Assert.assertTrue(mainActivity.getRouter().getBackstack().size()>0);
        Assert.assertNotNull(mainActivity.getRouter().getBackstack().get(0));
        Assert.assertTrue(mainActivity.getRouter().getBackstack().get(0).controller() instanceof TrendingListView);
    }
}
