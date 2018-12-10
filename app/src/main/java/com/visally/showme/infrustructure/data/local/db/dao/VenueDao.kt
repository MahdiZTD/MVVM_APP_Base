package com.visally.showme.infrustructure.data.local.db.dao

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.visally.showme.infrustructure.data.model.db.VenueModel

@Dao
interface VenueDao {

    @Query("SELECT * FROM venue_item")
    fun loadAllVenues(): LiveData<List<VenueModel>>

    @Query("SELECT * FROM venue_item order by (abs(:lng -(longitude)) +( abs(:lat-latitude)*2.1))")
    fun queryByLocation(lat:Float,lng:Float):LiveData<List<VenueModel>>

    @Query("SELECT COUNT(*) FROM venue_item ")
    fun isEmpty():Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVenue(venueList: MutableList<VenueModel>)
}