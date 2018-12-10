package com.visally.showme.infrustructure.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.visally.showme.infrustructure.data.local.db.dao.VenueDao
import com.visally.showme.infrustructure.data.model.db.VenueModel

@Database(entities = arrayOf(VenueModel::class), version = 1, exportSchema = false)
abstract class AppDatabase :RoomDatabase(){
    abstract fun venueDao(): VenueDao
}