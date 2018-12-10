package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class SearchVenueResponse(

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("response")
	val response: Response? = null
)