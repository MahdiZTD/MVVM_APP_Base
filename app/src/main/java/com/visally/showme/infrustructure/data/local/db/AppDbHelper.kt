package com.visally.showme.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import com.visally.showme.infrustructure.data.model.db.VenueModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject constructor(val appDatabase: AppDatabase) : DbHelper {
    override fun getAllVenueFromDb(): LiveData<List<VenueModel>>{
        return appDatabase.venueDao().loadAllVenues()
    }

    override fun insertVenueModel(venueModels: MutableList<VenueModel>) {
        appDatabase.venueDao().insertVenue(venueModels)
    }

    override fun getAllVenueByLocationFromDb(lat1: Float, lng1: Float, lat2: Float, lng2: Float): LiveData<MutableList<VenueModel>> {
        return appDatabase.venueDao().queryByLocation(lat1, lng1,lat2,lng2)
    }
}