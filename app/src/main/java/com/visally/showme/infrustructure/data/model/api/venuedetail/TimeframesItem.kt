package com.visally.showme.infrustructure.data.model.api.venuedetail

data class TimeframesItem(
	val includesToday: Boolean? = null,
	val days: String? = null,
	val open: List<OpenItem?>? = null,
	val segments: List<Any?>? = null
)
