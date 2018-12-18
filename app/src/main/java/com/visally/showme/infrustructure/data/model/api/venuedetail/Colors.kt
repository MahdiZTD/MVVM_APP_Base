package com.visally.showme.infrustructure.data.model.api.venuedetail


import com.google.gson.annotations.SerializedName

class Colors {

    @SerializedName("highlightColor")
    var highlightColor: HighlightColor? = null
    @SerializedName("highlightTextColor")
    var highlightTextColor: HighlightTextColor? = null
    @SerializedName("algoVersion")
    var algoVersion: Int? = null

}
