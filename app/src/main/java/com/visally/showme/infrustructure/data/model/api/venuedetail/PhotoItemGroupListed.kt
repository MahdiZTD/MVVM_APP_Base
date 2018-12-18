package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class PhotoItemGroupListed {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("createdAt")
    var createdAt: Int? = null
    @SerializedName("prefix")
    var prefix: String? = null
    @SerializedName("suffix")
    var suffix: String? = null
    @SerializedName("width")
    var width: Int? = null
    @SerializedName("height")
    var height: Int? = null
    @SerializedName("user")
    var user: UserPhotoItemGroupListed? = null
    @SerializedName("visibility")
    var visibility: String? = null

}
