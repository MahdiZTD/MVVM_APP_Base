package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class ItemReasons {

    @SerializedName("summary")
    var summary: String? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("reasonName")
    var reasonName: String? = null

}
