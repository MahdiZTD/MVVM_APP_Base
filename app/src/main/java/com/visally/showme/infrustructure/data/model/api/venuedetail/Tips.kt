package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Tips {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("groups")
    var groups: List<GroupTips>? = null

}
