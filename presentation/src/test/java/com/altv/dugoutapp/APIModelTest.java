package com.altv.dugoutapp;

import com.altv.dugout_data.data.IDataService;
import com.altv.dugoutapp.model.BoxsetCollection;
import com.altv.dugoutapp.model.BoxsetCollections;
import com.altv.dugoutapp.model.ClubOrPlayerDetail;
import com.altv.dugoutapp.model.ClubsOrPlayers;
import com.altv.dugoutapp.model.PlaylistContainer;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class APIModelTest {

    IDataService dataService;

    @Before
    public void setUp() {
//        dataService = new IDataService() {
//            @Override
//            public Observable<PlaylistContainer> getShowreel() {
//                return null;
//            }
//
//            @Override
//            public Observable<PlaylistContainer> getPlaylist(String id) {
//                return null;
//            }
//
//            @Override
//            public Observable<PlaylistContainer> getPlaylistLatest() {
//                return null;
//            }
//
//            @Override
//            public Observable<BoxsetCollections> getBoxsetCollections() {
//                return null;
//            }
//
//            @Override
//            public Observable<BoxsetCollection> getBoxsetCollection(String slug) {
//                return null;
//            }
//
//            @Override
//            public Observable<ClubsOrPlayers> getClubsBoxset() {
//                return null;
//            }
//
//            @Override
//            public Observable<ClubsOrPlayers> getPlayersBoxset() {
//                return null;
//            }
//
//            @Override
//            public Observable<ClubOrPlayerDetail> getClubDetail(String id) {
//                return null;
//            }
//
//            @Override
//            public Observable<ClubOrPlayerDetail> getPlayerDetail(String id) {
//                return null;
//            }
//        };
    }

    @Test
    public void isTablet() throws Exception {
//        TestObserver<PlaylistContainer> observer = TestObserver.create();
//
//        dataService.getPlaylistLatest().subscribe(observer);
//        observer.assertNoErrors();
//        observer.assertComplete();
//        Assert.assertThat(observer.getEvents().get(0).equals()).isEqualTo();
    }
}