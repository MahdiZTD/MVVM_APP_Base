package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("address")
    var address: String? = null
    @SerializedName("crossStreet")
    var crossStreet: String? = null
    @SerializedName("lat")
    var lat: Double? = null
    @SerializedName("lng")
    var lng: Double? = null
    @SerializedName("labeledLatLngs")
    var labeledLatLngs: List<LabeledLatLng>? = null
    @SerializedName("cc")
    var cc: String? = null
    @SerializedName("city")
    var city: String? = null
    @SerializedName("state")
    var state: String? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("formattedAddress")
    var formattedAddress: List<String>? = null

}
