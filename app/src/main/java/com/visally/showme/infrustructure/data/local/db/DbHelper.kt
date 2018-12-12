package com.visally.showme.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.visally.showme.infrustructure.data.model.db.VenueModel
import io.reactivex.Single


interface DbHelper {
    fun insertVenueModel(venueModels: MutableList<VenueModel>)
    fun getAllVenueFromDb(): LiveData<List<VenueModel>>
    fun getAllVenueByLocationFromDb(lat1: Float, lng1: Float, lat2: Float, lng2: Float): Single<MutableList<VenueModel>>
}