package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Photos {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("groups")
    var groups: List<GroupPhotos>? = null
    @SerializedName("summary")
    var summary: String? = null

}
