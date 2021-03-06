package com.visally.showme.infrustructure.data.remote

import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import com.visally.showme.infrustructure.data.model.api.venuedetail.VenueDetailResponse
import com.visally.showme.infrustructure.network.ForSquareInterface
import com.visally.showme.infrustructure.network.RetrofitRepository
import io.reactivex.Single


class AppApiHelper : ApiHelper {
    override fun getNearVenueByLocationFromApi(location: String, clientId: String, clientSecret: String, date: String, limit:Int, offset:Int):Single<SearchVenueResponse> {
        return RetrofitRepository()
                .getForSquareRetrofit()
                .create(ForSquareInterface::class.java)
                .getNearVenueByLocation(location, clientId, clientSecret, date,limit,offset)
    }

    override fun getVenueById(clientId: String, clientSecret: String, date: String, venueId: String):Single<VenueDetailResponse> {
        return RetrofitRepository()
                .getForSquareRetrofit()
                .create(ForSquareInterface::class.java)
                .getVenueDetailById(venueId,clientId, clientSecret, date)
    }



}