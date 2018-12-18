package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class GroupListed {

    @SerializedName("type")
    var type: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("count")
    var count: Int? = null
    @SerializedName("items")
    var items: List<ItemGroupListed>? = null

}
