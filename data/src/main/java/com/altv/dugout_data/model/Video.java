
package com.altv.dugout_data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
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
    private String teamFullName;
    @SerializedName("teamCode")
    @Expose
    private String teamCode;


//    public String getPreviewImage(Context context) {
//        String url = previewImageH240;
//        if(previewImages != null) {
//            url = previewImages.getH360();
//            if(!Utils.isPhone(context)) {
//                url = previewImages.getH720();
//            }
//            if(url == null) {
//                url = previewImageH240;
//            }
//        }
//
//        return url;
//    }

}
