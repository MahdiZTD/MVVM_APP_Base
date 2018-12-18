package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Inbox {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("items")
    var items: List<Any>? = null

}
