package com.visally.showme.ui.venuelist

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.LinearLayoutManager
import com.visally.showme.ViewModelProviderFactory
import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.data.model.api.searchvenue.Venue
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import com.visally.showme.ui.venuelist.adapter.VenueRecyclerViewAdapter
import dagger.Module
import dagger.Provides
import java.util.ArrayList

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 10/17/2018.
 */
@Module
class VenueListModule {
    @Provides
    fun provideViewModelProvider(venueListViewModel: VenueListViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(venueListViewModel)
    }

    @Provides
    fun provideVenueViewModel(dataManager: DataManager, schedulersProvider: SchedulersProvider): VenueListViewModel {
        return VenueListViewModel(dataManager,schedulersProvider)
    }


    @Provides
    internal fun provideLinearLayoutManager(activity: VenueListActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }


    @Provides
    internal fun provideVenueAdapter(): VenueRecyclerViewAdapter {
        return VenueRecyclerViewAdapter(ArrayList())
    }
}