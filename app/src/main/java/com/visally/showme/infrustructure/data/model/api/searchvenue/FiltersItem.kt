package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class FiltersItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("key")
	val key: String? = null
)