package com.visally.showme.ui.venuedetail

import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.utils.AppConstants
import com.visally.showme.infrustructure.utils.getDate
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import com.visally.showme.ui.base.BaseViewModel
import timber.log.Timber


class VenueDetailViewModel constructor(val dataManager: DataManager, val schedulersProvider: SchedulersProvider) : BaseViewModel<VenueDetailNavigator>(schedulersProvider, dataManager) {
    var latitude: String? = null
    var longitude: String? = null
    var placeName: String? = null
    var phoneNumber:String? = null

    fun getVenueDetail(id: String) {
        compositeDisposable.add(
                dataManager.getVenueById(AppConstants.CLIET_ID,
                        AppConstants.CLIET_SECRET,
                        getDate(), id)
                        .subscribeOn(schedulersProvider.io())
                        .observeOn(schedulersProvider.ui())
                        .subscribe({
                            mNavigator.get()?.loadVenueDetailData(it)
                            latitude = it.response?.venue?.location?.lat?.toString()
                            longitude = it.response?.venue?.location?.lng?.toString()
                            placeName = it.response?.venue?.name
                            phoneNumber = it.response?.venue?.contact?.phone
                        }, {
                            it.printStackTrace()
                        })
        )
    }

    fun onMapClick() {
        mNavigator.get()?.openMap(latitude,longitude,placeName)
    }

    fun onCallClicked(){
        mNavigator.get()?.callPlace(phoneNumber)
    }
}