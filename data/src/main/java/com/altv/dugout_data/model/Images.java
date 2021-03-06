
package com.altv.dugout_data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("x1")
    @Expose
    private X1 x1;
    @SerializedName("x2")
    @Expose
    private X2 x2;
    @SerializedName("user_badge")
    @Expose
    private UserBadge userBadge;

    public X1 getX1() {
        return x1;
    }

    public void setX1(X1 x1) {
        this.x1 = x1;
    }

    public X2 getX2() {
        return x2;
    }

    public void setX2(X2 x2) {
        this.x2 = x2;
    }

    public UserBadge getUserBadge() {
        return userBadge;
    }

    public void setUserBadge(UserBadge userBadge) {
        this.userBadge = userBadge;
    }

}
