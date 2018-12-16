package com.visally.showme.infrustructure.data.model.api.venuedetail

data class TimeframesItem(
	val days: String? = null,
	val open: List<OpenItem?>? = null,
	val segments: List<Any?>? = null,
	val includesToday: Boolean? = null
)
