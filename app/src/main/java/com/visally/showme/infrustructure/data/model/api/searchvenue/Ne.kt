package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class Ne(

	@field:SerializedName("lng")
	val lng: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)