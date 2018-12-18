package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class VenueDetailResponse {

    @SerializedName("meta")
    var meta: Meta? = null
    @SerializedName("response")
    var response: Response? = null

}
