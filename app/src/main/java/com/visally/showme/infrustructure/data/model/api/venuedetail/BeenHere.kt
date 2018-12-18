package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class BeenHere {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("unconfirmedCount")
    var unconfirmedCount: Int? = null
    @SerializedName("marked")
    var marked: Boolean? = null
    @SerializedName("lastCheckinExpiredAt")
    var lastCheckinExpiredAt: Int? = null

}
