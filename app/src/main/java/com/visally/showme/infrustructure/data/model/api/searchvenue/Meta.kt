package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class Meta(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("requestId")
	val requestId: String? = null
)