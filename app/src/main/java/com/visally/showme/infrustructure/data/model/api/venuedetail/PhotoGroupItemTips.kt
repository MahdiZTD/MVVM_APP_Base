package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class PhotoGroupItemTips {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("createdAt")
    var createdAt: Int? = null
    @SerializedName("source")
    var source: SourcePhotoGroupItemTips? = null
    @SerializedName("prefix")
    var prefix: String? = null
    @SerializedName("suffix")
    var suffix: String? = null
    @SerializedName("width")
    var width: Int? = null
    @SerializedName("height")
    var height: Int? = null
    @SerializedName("visibility")
    var visibility: String? = null

}
