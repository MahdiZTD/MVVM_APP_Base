package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Timeframe {

    @SerializedName("days")
    var days: String? = null
    @SerializedName("includesToday")
    var includesToday: Boolean? = null
    @SerializedName("open")
    var open: List<Open>? = null
    @SerializedName("segments")
    var segments: List<Any>? = null

}
