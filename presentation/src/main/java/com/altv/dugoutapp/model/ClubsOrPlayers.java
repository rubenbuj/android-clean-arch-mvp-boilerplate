
package com.altv.dugoutapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClubsOrPlayers {

    @SerializedName("data")
    @Expose
    private List<DatumClubOrPlayer> data = null;

    public List<DatumClubOrPlayer> getData() {
        return data;
    }

    public void setData(List<DatumClubOrPlayer> data) {
        this.data = data;
    }

}
