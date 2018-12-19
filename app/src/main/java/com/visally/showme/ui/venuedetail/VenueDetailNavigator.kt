package com.visally.showme.ui.venuedetail

import com.visally.showme.infrustructure.data.model.api.venuedetail.VenueDetailResponse

interface VenueDetailNavigator{
    fun loadVenueDetailData(venueDetailResponse: VenueDetailResponse)
    fun openMap(latitude:String?,longitude:String?,placeName:String?)
    fun callPlace(tel:String?)
}