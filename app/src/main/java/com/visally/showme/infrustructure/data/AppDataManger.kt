package com.visally.showme.infrustructure.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.visally.showme.infrustructure.data.local.db.DbHelper
import com.visally.showme.infrustructure.data.local.prefs.PreferencesHelper
import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.data.remote.ApiHelper
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.Callable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppDataManger @Inject constructor(val context: Context, val dbHelper: DbHelper, val preferencesHelper: PreferencesHelper, val apiHelper: ApiHelper) : DataManager {
    override fun getAllVenueFromDb(): LiveData<List<VenueModel>> {
        return dbHelper.getAllVenueFromDb()
    }

    override fun insertVenueModel(venueModels: MutableList<VenueModel>) {
        dbHelper.insertVenueModel(venueModels)
    }

    override fun getAllVenueByLocationFromDb(lat1: Float, lng1: Float, lat2: Float, lng2: Float): LiveData<MutableList<VenueModel>> {
        return dbHelper.getAllVenueByLocationFromDb(lat1, lng1, lat2, lng2)
    }

    override fun getNearVenueByLocationFromApi(location: String, clientId: String, clientSecret: String, date: String, limit: Int, offset: Int): Single<SearchVenueResponse> {
        return apiHelper.getNearVenueByLocationFromApi(location, clientId, clientSecret, date, limit, offset)

    }


}