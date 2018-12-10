package com.visally.showme.infrustructure.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 12/9/2018.
 */

object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}
