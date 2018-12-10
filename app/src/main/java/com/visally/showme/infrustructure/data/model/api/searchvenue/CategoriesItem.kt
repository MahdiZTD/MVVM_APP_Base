package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class CategoriesItem(

	@field:SerializedName("pluralName")
	val pluralName: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("icon")
	val icon: Icon? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("shortName")
	val shortName: String? = null,

	@field:SerializedName("primary")
	val primary: Boolean? = null
)