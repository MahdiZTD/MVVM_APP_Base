package com.visally.showme.infrustructure.data.model.api.venuedetail

data class Hours(
	val isOpen: Boolean? = null,
	val timeframes: List<TimeframesItem?>? = null,
	val dayData: List<Any?>? = null,
	val richStatus: RichStatus? = null,
	val isLocalHoliday: Boolean? = null,
	val status: String? = null
)
