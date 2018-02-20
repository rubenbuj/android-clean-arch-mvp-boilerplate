
package com.altv.dugoutapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdTag {

    @SerializedName("networkCode")
    @Expose
    private String networkCode;
    @SerializedName("targeting")
    @Expose
    private Targeting targeting;
    @SerializedName("sharethroughid")
    @Expose
    private String sharethroughid;
    @SerializedName("number_of_cards_to_ads")
    @Expose
    private String numberOfCardsToAds;
    @SerializedName("header_bidding")
    @Expose
    private HeaderBidding headerBidding;

    public String getNetworkCode() {
        return networkCode;
    }

    public void setNetworkCode(String networkCode) {
        this.networkCode = networkCode;
    }

    public Targeting getTargeting() {
        return targeting;
    }

    public void setTargeting(Targeting targeting) {
        this.targeting = targeting;
    }

    public String getSharethroughid() {
        return sharethroughid;
    }

    public void setSharethroughid(String sharethroughid) {
        this.sharethroughid = sharethroughid;
    }

    public String getNumberOfCardsToAds() {
        return numberOfCardsToAds;
    }

    public void setNumberOfCardsToAds(String numberOfCardsToAds) {
        this.numberOfCardsToAds = numberOfCardsToAds;
    }

    public HeaderBidding getHeaderBidding() {
        return headerBidding;
    }

    public void setHeaderBidding(HeaderBidding headerBidding) {
        this.headerBidding = headerBidding;
    }

//    public String getKey() {
//        return networkCode+(targeting != null?targeting.getKey():"");
//    }
}
