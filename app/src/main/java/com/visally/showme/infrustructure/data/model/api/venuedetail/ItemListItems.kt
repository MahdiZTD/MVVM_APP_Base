package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class ItemListItems {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("createdAt")
    var createdAt: Int? = null
    @SerializedName("photo")
    var photo: PhotoItemListItems? = null

}
