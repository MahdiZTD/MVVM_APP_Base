package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Attributes {

    @SerializedName("groups")
    var groups: List<GroupAttributes>? = null

}
