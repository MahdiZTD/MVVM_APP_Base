package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class Photos(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("groups")
	val groups: List<Any?>? = null
)