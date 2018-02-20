package com.altv.dugoutapp;

import com.altv.dugoutapp.state_machines.StateMachine;
import com.altv.dugoutapp.trending_list.TrendingListPresenter;
import com.altv.dugoutapp.trending_list.TrendingListView;
import com.bluelinelabs.conductor.Router;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by rubenbujalance on 07/02/2018.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class TrendingListViewTest {

    private TrendingListView trendingListView;
    private Router router;
    private MainActivity mainActivity;

    @Mock
    TrendingListPresenter presenter;
    @Mock
    StateMachine stateMachineHandler;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

        MockitoAnnotations.initMocks(this);
        router = mainActivity.getRouter();
        trendingListView = (TrendingListView)router.getBackstack().get(0).controller();
        trendingListView.setPresenter(presenter);

        Thread.sleep(5000);

//        trendingListView.
//        trendingListController.setPresenter(presenter);
    }

    @Test
    public void testStart() throws Exception {
//        Shadows.shadowOf(trendingListView.);
//        Mockito.verify(presenter).onAttach();
//        PlaylistContainer playlistContainerSample = TestUtils.getPlaylistContainerSample();
//        trendingListView.setListData(playlistContainerSample);
//        Assert.assertNotNull(trendingListView.adapter);
//        Assert.assertTrue(trendingListView.adapter.getItemCount()>0);
//        Assert.assertTrue(trendingListView.recyclerView.isShown());
    }

    @Test
    public void testLeave() throws Exception {
//        trendingListView.detach();
//        Mockito.verify(presenter).onDetach();
    }

    @Test
    public void testReturnToView() throws Exception {
        // TODO: Check if state is being kept
    }

    @Test
    public void testItemClick() throws Exception {
//        trendingListView.setListData(TestUtils.getPlaylistContainerSample());

    }
}
