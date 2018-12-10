package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class Venue(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

	@field:SerializedName("photos")
	val photos: Photos? = null
)