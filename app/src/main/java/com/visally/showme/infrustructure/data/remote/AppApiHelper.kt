package com.visally.showme.infrustructure.data.remote

import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import com.visally.showme.infrustructure.network.ForSquerInterface
import com.visally.showme.infrustructure.network.RetrofitRepository
import io.reactivex.Single


class AppApiHelper : ApiHelper {
    override fun getNearVenueByLocationFromApi(location: String, clientId: String, clientSecret: String, date: String, limit:Int, offset:Int):Single<SearchVenueResponse> {
        return RetrofitRepository()
                .getForSquareRetrofit()
                .create(ForSquerInterface::class.java)
                .getNearVenueByLocation(location, clientId, clientSecret, date,limit,offset)
    }


}