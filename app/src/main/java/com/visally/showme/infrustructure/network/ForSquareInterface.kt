package com.visally.showme.infrustructure.network

import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 9/11/2018.
 */
interface ForSquareInterface {

    @GET("/v2/venues/explore?")
    fun getNearVenueByLocation(@Query("ll") location:String ,
                               @Query("client_id") clientId:String,
                               @Query("client_secret") clientSecret:String,
                               @Query("v") date:String,
                               @Query("limit") limit:Int,
                               @Query("offset") offset:Int):Single<SearchVenueResponse>

}