package com.altv.dugoutapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClubOrPlayerDetail {


    @SerializedName("playlists")
    @Expose
    private final List<Playlist> playlists = null;

    public List<Playlist> getPlaylists() {
        return playlists;
    }


}
