
package com.altv.dugoutapp.model;

import android.content.Context;

import com.altv.dugoutapp.Utils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Video implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("embed_code")
    @Expose
    private String embedCode;
    @SerializedName("preview_image_h240")
    @Expose
    private String previewImageH240;
    @SerializedName("preview_images")
    @Expose
    private PreviewImages previewImages;
    @SerializedName("ad_tag")
    @Expose
    private AdTag adTag;
    @SerializedName("user_type_id")
    @Expose
    private String userTypeId;
    @SerializedName("owner_fullname")
    @Expose
    private String ownerFullName;
    @SerializedName("teamCode")
    @Expose
    private String owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }

    public String getPreviewImageH240() {
        return previewImageH240;
    }

    public void setPreviewImageH240(String previewImageH240) {
        this.previewImageH240 = previewImageH240;
    }

    public PreviewImages getPreviewImages() {
        return previewImages;
    }

    public void setPreviewImages(PreviewImages previewImages) {
        this.previewImages = previewImages;
    }

    public String getPreviewImage(Context context) {
        String url = previewImageH240;
        if(previewImages != null) {
            url = previewImages.getH360();
            if(!Utils.isPhone(context)) {
                url = previewImages.getH720();
            }
            if(url == null) {
                url = previewImageH240;
            }
        }

        return url;
    }

    public AdTag getAdTag() {
        return adTag;
    }

    public void setAdTag(AdTag adTag) {
        this.adTag = adTag;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

}
