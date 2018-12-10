package com.visally.showme.infrustructure.utils

import android.content.Context
import android.net.ConnectivityManager

/*************************************
 *This File Is created By
 * mahdi_TD
 * on
 * 7/3/2018  10:14 AM.
 *************************************/

object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}
