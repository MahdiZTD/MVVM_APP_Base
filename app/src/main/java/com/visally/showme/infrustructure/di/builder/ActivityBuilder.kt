package com.visally.showme.infrustructure.di.builder

import com.visally.showme.ui.venuelist.VenueListActivity
import com.visally.showme.ui.venuelist.VenueListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
//    @ContributesAndroidInjector(modules = [NewsListModule::class , MenuProvider::class])
//    abstract fun bindNewsListActivity(): NewsListActivity
//
    @ContributesAndroidInjector(modules = [VenueListModule::class])
    abstract fun binVenueListActivity(): VenueListActivity
}