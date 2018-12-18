package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class LikesItemsGroupTips {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("groups")
    var groups: List<GroupLikesItemsGroupTips>? = null
    @SerializedName("summary")
    var summary: String? = null

}
