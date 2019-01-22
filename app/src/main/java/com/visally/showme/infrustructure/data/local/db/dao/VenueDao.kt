package com.visally.showme.infrustructure.data.local.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.visally.showme.infrustructure.data.model.db.VenueModel
import io.reactivex.Single

@Dao
interface VenueDao {

    @Query("SELECT * FROM venue_item")
    fun loadAllVenues(): LiveData<List<VenueModel>>

    @Query("SELECT * FROM venue_item WHERE (latitude > :lat1-0.0044915765 AND latitude < :lat1+0.0044915765 AND longitude > :lng1-0.0044915765 AND longitude < :lng1+0.0044915765)")
    fun queryByLocation(lat1: Float, lng1: Float): Single<MutableList<VenueModel>>

    @Query("SELECT * FROM venue_item WHERE :placeId == place_id")
    fun getVenueById(placeId:String): LiveData<VenueModel>

    @Query("SELECT COUNT(*) FROM venue_item ")
    fun isEmpty(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVenueList(venueList: MutableList<VenueModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVenue(venueList: VenueModel)
}