package com.altv.dugout_data.data;


import com.altv.dugout_data.model.BoxsetCollection;
import com.altv.dugout_data.model.BoxsetCollections;
import com.altv.dugout_data.model.ClubOrPlayerDetail;
import com.altv.dugout_data.model.ClubsOrPlayers;
import com.altv.dugout_data.model.PlaylistContainer;

import io.reactivex.Observable;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public interface IDataService {

    Observable<PlaylistContainer> getShowreel();
    Observable<PlaylistContainer> getPlaylist(String id);
    Observable<PlaylistContainer> getPlaylistLatest();
    Observable<BoxsetCollections> getBoxsetCollections();
    Observable<BoxsetCollection> getBoxsetCollection(String slug);
    Observable<ClubsOrPlayers> getClubsBoxset();
    Observable<ClubsOrPlayers> getPlayersBoxset();
    Observable<ClubOrPlayerDetail> getClubDetail(String id);
    Observable<ClubOrPlayerDetail> getPlayerDetail(String id);

}
