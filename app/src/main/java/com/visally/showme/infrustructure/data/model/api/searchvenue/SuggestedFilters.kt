package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class SuggestedFilters(

	@field:SerializedName("header")
	val header: String? = null,

	@field:SerializedName("filters")
	val filters: List<FiltersItem?>? = null
)