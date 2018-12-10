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

    @Query("SELECT * FROM venue_item WHERE (latitude > :lat1 AND latitude < :lat2 AND longitude > :lng1 AND longitude < :lng2)")
    fun queryByLocation(lat1: Float, lng1: Float, lat2: Float, lng2: Float): LiveData<MutableList<VenueModel>>

    @Query("SELECT COUNT(*) FROM venue_item ")
    fun isEmpty(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertVenue(venueList: MutableList<VenueModel>)
}