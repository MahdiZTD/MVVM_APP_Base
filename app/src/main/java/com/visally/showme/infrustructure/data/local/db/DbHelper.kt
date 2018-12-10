package com.visally.showme.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.visally.showme.infrustructure.data.model.db.VenueModel


interface DbHelper {
    fun insertVenueModel(venueModels:MutableList<VenueModel>)
    fun getAllVenueFromDb():LiveData<List<VenueModel>>
    fun getAllVenueByLocationFromDb(lat:Float, lng:Float):LiveData<List<VenueModel>>
}