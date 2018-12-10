package com.visally.showme.infrustructure.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.visally.showme.infrustructure.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferencesHelper @Inject constructor(context: Context, @PreferenceInfo prefFileName:String):PreferencesHelper {
    private var mPref:SharedPreferences

    init {
        mPref = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE)
    }
}