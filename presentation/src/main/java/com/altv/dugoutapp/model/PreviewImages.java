
package com.altv.dugoutapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class PreviewImages {

    @SerializedName("h360")
    @Expose
    private String h360;
    @SerializedName("h720")
    @Expose
    private String h720;

    public String getH360() {
        return h360;
    }

    public void setH360(String h360) {
        this.h360 = h360;
    }

    public String getH720() {
        return h720;
    }

    public void setH720(String h720) {
        this.h720 = h720;
    }
}
