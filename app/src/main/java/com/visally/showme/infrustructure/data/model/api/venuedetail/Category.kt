package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Category {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("pluralName")
    var pluralName: String? = null
    @SerializedName("shortName")
    var shortName: String? = null
    @SerializedName("icon")
    var icon: Icon? = null
    @SerializedName("primary")
    var primary: Boolean? = null

}
