package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class Reasons(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)