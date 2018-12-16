package com.visally.showme.infrustructure.utils

class AppConstants {
    companion object {
        val DB_NAME = "SHOW_ME_DATABASE"
        val PREF_NAME = "SHOW_Me_PREF"
        val CLIET_SECRET = "IV2GRPILE2CC5ZFSHJR1GAEZZPON44OZIM1SFYXUEMKZMCBK"
        val CLIET_ID = "2ZD0Z2KBGZOWWBX5NVLUI4PWET1RKTCFDEK5F1NLNUH2OWSI"
        val PAGE_LIMIT = 10
        val METER_DISTANCE = ((1 / ((2 * Math.PI / 360) * 6378.137)) /2).toFloat()
    }
}