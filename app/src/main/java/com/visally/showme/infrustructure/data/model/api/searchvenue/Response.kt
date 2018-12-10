package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class Response(

	@field:SerializedName("suggestedFilters")
	val suggestedFilters: SuggestedFilters? = null,

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("suggestedRadius")
	val suggestedRadius: Int? = null,

	@field:SerializedName("headerFullLocation")
	val headerFullLocation: String? = null,

	@field:SerializedName("headerLocationGranularity")
	val headerLocationGranularity: String? = null,

	@field:SerializedName("groups")
	val groups: List<GroupsItem?>? = null,

	@field:SerializedName("suggestedBounds")
	val suggestedBounds: SuggestedBounds? = null,

	@field:SerializedName("headerLocation")
	val headerLocation: String? = null
)