package com.altv.dugout_data.network;

import com.altv.dugout_data.model.BoxsetCollection;
import com.altv.dugout_data.model.BoxsetCollections;
import com.altv.dugout_data.model.ClubOrPlayerDetail;
import com.altv.dugout_data.model.ClubsOrPlayers;
import com.altv.dugout_data.model.PlaylistContainer;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public class NewsApiDataSource {

    @Inject
    NewsApiDataSource() {}

    public Observable<PlaylistContainer> getShowreel() {
        return ApiModule.provideRemoteClient().getShowreel();
    }

    public Observable<PlaylistContainer> getPlaylist(String id) {
        return ApiModule.provideRemoteClient().getPlaylist(id);
    }

    public Observable<PlaylistContainer> getPlaylistLatest() {
        return ApiModule.provideRemoteClient().getPlaylistLatest();
    }

    public Observable<BoxsetCollections> getBoxsetCollections() {
        return ApiModule.provideRemoteClient().getBoxsetCollections();
    }

    public Observable<BoxsetCollection> getBoxsetCollection(String slug) {
        return ApiModule.provideRemoteClient().getBoxsetCollection(slug);
    }

    public Observable<ClubsOrPlayers> getClubsBoxset() {
        return ApiModule.provideRemoteClient().getClubsBoxset();
    }

    public Observable<ClubsOrPlayers> getPlayersBoxset() {
        return ApiModule.provideRemoteClient().getPlayersBoxset();
    }

    public Observable<ClubOrPlayerDetail> getClubDetail(String id) {
        return ApiModule.provideRemoteClient().getClubDetail(id);
    }

    public Observable<ClubOrPlayerDetail> getPlayerDetail(String id) {
        return ApiModule.provideRemoteClient().getPlayerDetail(id);
    }
}
