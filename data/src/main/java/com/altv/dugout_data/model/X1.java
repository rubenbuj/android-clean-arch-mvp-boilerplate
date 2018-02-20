
package com.altv.dugout_data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class X1 {

    @SerializedName("badge")
    @Expose
    private String badge;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("club_logo")
    @Expose
    private String clubLogo;
    @SerializedName("pro_profile_picture")
    @Expose
    private String proProfilePicture;

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public String getProProfilePicture() {
        return proProfilePicture;
    }

    public void setProProfilePicture(String proProfilePicture) {
        this.proProfilePicture = proProfilePicture;
    }

}
