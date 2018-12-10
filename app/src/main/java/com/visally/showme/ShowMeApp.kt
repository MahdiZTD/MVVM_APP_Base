package com.visally.showme

import android.app.Activity
import android.app.Application
import com.visally.showme.infrustructure.di.component.DaggerAppComponent
import com.visally.showme.infrustructure.utils.AppLogger
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class ShowMeApp : Application(),HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var mCalligraphyConfig: CalligraphyConfig

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
         return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
        AppLogger.init()
        CalligraphyConfig.initDefault(mCalligraphyConfig)

    }
}