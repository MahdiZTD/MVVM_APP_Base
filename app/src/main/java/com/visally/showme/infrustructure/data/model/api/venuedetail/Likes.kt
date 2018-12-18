package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Likes {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("groups")
    var groups: List<GroupLikes>? = null
    @SerializedName("summary")
    var summary: String? = null

}
