package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Popular {

    @SerializedName("isOpen")
    var isOpen: Boolean? = null
    @SerializedName("isLocalHoliday")
    var isLocalHoliday: Boolean? = null
    @SerializedName("timeframes")
    var timeframes: List<Timeframe>? = null

}
