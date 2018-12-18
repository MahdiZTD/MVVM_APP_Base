package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("firstName")
    var firstName: String? = null
    @SerializedName("gender")
    var gender: String? = null
    @SerializedName("photo")
    var photo: PhotoUser? = null

}
