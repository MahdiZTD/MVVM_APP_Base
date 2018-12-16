package com.visally.showme.ui.venuedetail

import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.utils.AppConstants
import com.visally.showme.infrustructure.utils.getDate
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import com.visally.showme.ui.base.BaseViewModel

class VenueDetailViewModel constructor(val dataManager: DataManager, val schedulersProvider: SchedulersProvider) : BaseViewModel<VenueDetailNavigator>(schedulersProvider, dataManager) {

    fun getVenueDetail(id: String) {
        compositeDisposable.add(
                dataManager.getVenueById(AppConstants.CLIET_ID,
                        AppConstants.CLIET_SECRET,
                        getDate(), id)
                        .subscribeOn(schedulersProvider.io())
                        .observeOn(schedulersProvider.ui())
                        .subscribe({
                            mNavigator.get()?.loadVenueDetailData(it)
                        }, {
                            it.printStackTrace()
                        })
        )
    }
}