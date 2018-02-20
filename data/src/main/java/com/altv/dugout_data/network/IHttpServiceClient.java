package com.altv.dugout_data.network;

import com.altv.dugout_data.model.BoxsetCollection;
import com.altv.dugout_data.model.BoxsetCollections;
import com.altv.dugout_data.model.ClubOrPlayerDetail;
import com.altv.dugout_data.model.ClubsOrPlayers;
import com.altv.dugout_data.model.PlaylistContainer;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IHttpServiceClient {

    @GET("boxsets/playlists/3aecc53d7ca74a4ba26a145a5a37e5c6")
    Observable<PlaylistContainer> getShowreel();

    @GET("boxsets/playlists/{id}")
    Observable<PlaylistContainer> getPlaylist(@Path("id") String id);

    @GET("boxsets/playlists/latest")
    Observable<PlaylistContainer> getPlaylistLatest();

    @GET("boxsets/collections")
    Observable<BoxsetCollections> getBoxsetCollections();

    @GET("boxsets/collections/{slug}")
    Observable<BoxsetCollection> getBoxsetCollection(@Path("slug") String slug);

    @GET("boxsets/clubs")
    Observable<ClubsOrPlayers> getClubsBoxset();

    @GET("boxsets/players")
    Observable<ClubsOrPlayers> getPlayersBoxset();

    @GET("boxsets/clubs/{id}")
    Observable<ClubOrPlayerDetail> getClubDetail(@Path("id") String id);

    @GET("boxsets/players/{id}")
    Observable<ClubOrPlayerDetail> getPlayerDetail(@Path("id") String id);

}


