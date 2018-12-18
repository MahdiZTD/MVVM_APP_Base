package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Contact {

    @SerializedName("phone")
    var phone: String? = null
    @SerializedName("formattedPhone")
    var formattedPhone: String? = null

}
