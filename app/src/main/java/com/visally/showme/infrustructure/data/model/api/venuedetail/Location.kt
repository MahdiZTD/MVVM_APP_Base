package com.visally.showme.infrustructure.data.model.api.venuedetail

data class Location(
	val cc: String? = null,
	val country: String? = null,
	val address: String? = null,
	val labeledLatLngs: List<LabeledLatLngsItem?>? = null,
	val lng: Double? = null,
	val formattedAddress: List<String?>? = null,
	val city: String? = null,
	val postalCode: String? = null,
	val state: String? = null,
	val crossStreet: String? = null,
	val lat: Double? = null
)
