package com.visally.showme.infrustructure.data.remote

import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import io.reactivex.Single

interface ApiHelper {
    fun getNearVenueByLocationFromApi(location: String, clientId: String, clientSecret: String, date: String, limit:Int, offset:Int):Single<SearchVenueResponse>
}