
package com.altv.dugout_data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaylistContainer {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("playlist")
    @Expose
    private String playlist;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("teamCode")
    @Expose
    private String owner;
    @SerializedName("image_ref")
    @Expose
    private String imageRef;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;
    @SerializedName("user_type_id")
    @Expose
    private String userTypeId;
    @SerializedName("ad_tag")
    @Expose
    private AdTag adTag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public AdTag getAdTag() {
        return adTag;
    }

    public void setAdTag(AdTag adTag) {
        this.adTag = adTag;
    }

}
