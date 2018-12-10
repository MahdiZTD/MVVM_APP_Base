package com.visally.showme.infrustructure.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.ui.venuelist.adapter.VenueRecyclerViewAdapter

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 12/8/2018.
 */
object BindingUtils {

    @JvmStatic
    @BindingAdapter("adapter")
    fun addVenueItem(recyclerView: RecyclerView, venues: MutableList<VenueModel>) {
        val adapter = recyclerView.adapter as VenueRecyclerViewAdapter?
        adapter?.clearItems()
        adapter?.addItems(venues)
    }

}