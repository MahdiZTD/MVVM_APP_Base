package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class HereNow {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("summary")
    var summary: String? = null
    @SerializedName("groups")
    var groups: List<Any>? = null

}
