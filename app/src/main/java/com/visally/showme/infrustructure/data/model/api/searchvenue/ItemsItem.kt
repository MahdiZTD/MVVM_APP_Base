package com.visally.showme.infrustructure.data.model.api.searchvenue


import com.google.gson.annotations.SerializedName


data class ItemsItem(

	@field:SerializedName("venue")
	val venue: Venue? = null,

	@field:SerializedName("reasons")
	val reasons: Reasons? = null,

	@field:SerializedName("referralId")
	val referralId: String? = null,

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("reasonName")
	val reasonName: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)