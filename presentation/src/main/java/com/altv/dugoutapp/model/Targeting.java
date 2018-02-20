
package com.altv.dugoutapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Targeting {

    @SerializedName("pid")
    @Expose
    private String pid;
    @SerializedName("s1")
    @Expose
    private String s1;
    @SerializedName("s2")
    @Expose
    private String s2;
    @SerializedName("s3")
    @Expose
    private String s3;
    @SerializedName("club")
    @Expose
    private String club;
    @SerializedName("league")
    @Expose
    private String league;
    @SerializedName("pgtype")
    @Expose
    private String pgtype;
    @SerializedName("logstat")
    @Expose
    private String logstat;
    @SerializedName("player")
    @Expose
    private String player;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getPgtype() {
        return pgtype;
    }

    public void setPgtype(String pgtype) {
        this.pgtype = pgtype;
    }

    public String getLogstat() {
        return logstat;
    }

    public void setLogstat(String logstat) {
        this.logstat = logstat;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getKey() {
        return s1+s2+s3;
    }
}
