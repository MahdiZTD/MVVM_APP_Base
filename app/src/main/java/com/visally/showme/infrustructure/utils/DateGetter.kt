package com.visally.showme.infrustructure.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 12/15/2018.
 */


fun getDate(): String {
    val calendar = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.ENGLISH)
    return dateFormat.format(calendar)
}