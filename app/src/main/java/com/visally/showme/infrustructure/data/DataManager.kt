package com.visally.showme.infrustructure.data

import android.arch.lifecycle.LiveData
import com.visally.showme.infrustructure.data.local.db.DbHelper
import com.visally.showme.infrustructure.data.local.prefs.PreferencesHelper
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.data.remote.ApiHelper


/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 7/12/2018.
 */
interface DataManager : ApiHelper, DbHelper, PreferencesHelper {
}