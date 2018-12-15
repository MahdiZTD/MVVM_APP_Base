package com.visally.showme.ui.venuelist.adapter

import android.databinding.ObservableField
import com.visally.showme.infrustructure.data.model.db.VenueModel
import timber.log.Timber

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 12/8/2018.
 */

class VenueItemViewModel(private val mVenue: VenueModel, val mListener: VenueItemClickListener) {
    private val venueName: ObservableField<String> = ObservableField(mVenue.name!!)

    private val address: ObservableField<String> = ObservableField(mVenue.formattedAddress!!)

    private val category: ObservableField<String> = ObservableField(mVenue.category!!)

    private val distance: ObservableField<String> = ObservableField(mVenue.distance!!)

    fun onItemClick() {
        Timber.d("clicked in view model")
        mListener.onItemClick(mVenue.placeId)
    }

    interface VenueItemClickListener {
        fun onItemClick(id: String)
    }
}
