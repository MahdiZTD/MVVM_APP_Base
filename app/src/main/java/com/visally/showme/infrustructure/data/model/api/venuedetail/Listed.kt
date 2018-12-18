package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Listed {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("groups")
    var groups: List<GroupListed>? = null

}
