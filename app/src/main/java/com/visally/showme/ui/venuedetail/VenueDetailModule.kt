package com.visally.showme.ui.venuedetail

import android.arch.lifecycle.ViewModelProvider
import com.visally.showme.ViewModelProviderFactory
import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import dagger.Module
import dagger.Provides

@Module
class VenueDetailModule {

    @Provides
    fun provideViewModelProvider(venueDetailViewModel: VenueDetailViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(venueDetailViewModel)
    }

    @Provides
    fun provideVenueViewModel(dataManager: DataManager, schedulersProvider: SchedulersProvider): VenueDetailViewModel {
        return VenueDetailViewModel(dataManager,schedulersProvider)
    }
}