package com.visally.showme.infrustructure.data.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "venue_item")
data class VenueModel constructor(
        @PrimaryKey
        @ColumnInfo(name = "place_id")
        val placeId: String,
        @ColumnInfo(name = "latitude")
        var latitude: Float?,
        @ColumnInfo(name = "longitude")
        var longitude: Float?,
        @ColumnInfo(name = "name")
        var name: String?,
        @ColumnInfo(name = "cross_street")
        var crossStreet: String?,
        @ColumnInfo(name = "distance")
        var distance: String?,
        @ColumnInfo(name = "formatted_address")
        var formattedAddress: String?,
        @ColumnInfo(name = "city")
        var city: String?,
        @ColumnInfo(name = "category")
        var category: String?){
}