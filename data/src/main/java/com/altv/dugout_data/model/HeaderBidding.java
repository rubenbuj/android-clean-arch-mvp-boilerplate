
package com.altv.dugout_data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeaderBidding {

    @SerializedName("accountId")
    @Expose
    private Long accountId;
    @SerializedName("siteId")
    @Expose
    private Long siteId;
//    @SerializedName("bidders")
//    @Expose
//    private List<Bidder> bidders = null;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

//    public List<Bidder> getBidders() {
//        return bidders;
//    }
//
//    public void setBidders(List<Bidder> bidders) {
//        this.bidders = bidders;
//    }

}
