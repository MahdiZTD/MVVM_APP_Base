package com.visally.showme.infrustructure.data.model.api.venuedetail

data class Popular(
	val isOpen: Boolean? = null,
	val timeframes: List<TimeframesItem?>? = null,
	val richStatus: RichStatus? = null,
	val isLocalHoliday: Boolean? = null,
	val status: String? = null
)