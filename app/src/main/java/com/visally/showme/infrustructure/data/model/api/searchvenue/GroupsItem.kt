package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class GroupsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)