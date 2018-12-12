package com.visally.showme.infrustructure.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.visally.showme.R
import com.visally.showme.infrustructure.data.AppDataManger
import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.data.local.db.AppDatabase
import com.visally.showme.infrustructure.data.local.db.AppDbHelper
import com.visally.showme.infrustructure.data.local.db.DbHelper
import com.visally.showme.infrustructure.data.local.prefs.AppPreferencesHelper
import com.visally.showme.infrustructure.data.local.prefs.PreferencesHelper
import com.visally.showme.infrustructure.data.remote.ApiHelper
import com.visally.showme.infrustructure.data.remote.AppApiHelper
import com.visally.showme.infrustructure.di.DatabaseInfo
import com.visally.showme.infrustructure.di.PreferenceInfo
import com.visally.showme.infrustructure.utils.AppConstants
import com.visally.showme.infrustructure.utils.rx.AppSchedulerProvider
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName:String, context: Context): AppDatabase {
        return Room.databaseBuilder(context,AppDatabase::class.java,dbName).fallbackToDestructiveMigration().build()
    }

    @Provides
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    internal fun provideCompositeDisposable(): CompositeDisposable{
        return CompositeDisposable()
    }


    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun providePreferenceHelper(preferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return preferencesHelper
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName():String{
        return AppConstants.PREF_NAME
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulersProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application):Context{
        return application
    }


    @Provides
    @Singleton
    fun provideDataManager(dataManager: AppDataManger): DataManager {
        return dataManager
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()}


    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
    }


    @Provides
    @Singleton
    internal fun provideApiHelper(): ApiHelper {
        return AppApiHelper()
    }


}