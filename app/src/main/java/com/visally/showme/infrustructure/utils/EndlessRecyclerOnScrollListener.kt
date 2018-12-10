package com.visally.showme.infrustructure.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import timber.log.Timber


/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 12/9/2018.
 */
abstract class EndlessRecyclerOnScrollListener : RecyclerView.OnScrollListener() {
    //    public static String TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();

    /**
     * The total number of items in the dataset after the last load
     */
    private var mPreviousTotal = 0
    /**
     * True if we are still waiting for the last set of data to load.
     */
    private var mLoading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView.childCount
        val totalItemCount = recyclerView.layoutManager!!.itemCount
        val firstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
//        Timber.d(visibleItemCount.toString() + "\n"+totalItemCount.toString() + "\n" + firstVisibleItem.toString() )

        if (mLoading) {
            if (totalItemCount > mPreviousTotal) {
                mLoading = false
                mPreviousTotal = totalItemCount
            }
        }
        val visibleThreshold = 5
        if (!mLoading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
            // End has been reached
//            Timber.d("LOAD_MORE")
            onLoadMore()

            mLoading = true
        }
    }

    abstract fun onLoadMore()
}