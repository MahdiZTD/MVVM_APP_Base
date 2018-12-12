package com.visally.showme.ui.venuelist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import com.visally.showme.infrustructure.data.model.api.searchvenue.Venue
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.utils.AppConstants
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import com.visally.showme.ui.base.BaseViewModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*


class VenueListViewModel constructor(val dataManager: DataManager, val schedulersProvider: SchedulersProvider) : BaseViewModel<VenueListNavigator>(schedulersProvider, dataManager) {
    val venueModels = MutableLiveData<MutableList<VenueModel>>()
    var venueObservableArrayList: ObservableList<VenueModel> = ObservableArrayList()

    fun getNearVenue(lat: Float, lng: Float, page: Int) {
        val location = lat.toString() + "," + lng.toString()
        compositeDisposable.add(dataManager.getNearVenueByLocationFromApi(location,
                AppConstants.CLIET_ID,
                AppConstants.CLIET_SECRET, getDate(),
                AppConstants.PAGE_LIMIT,
                page * AppConstants.PAGE_LIMIT)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe({ searchVenueModel: SearchVenueResponse? ->
                    val venueModel: MutableList<VenueModel> = mutableListOf()
                    searchVenueModel?.response?.groups?.forEach {
                        it?.items?.forEach { group ->
                            venueModel.add(VenueModel(group?.venue?.id.toString()
                                    , group?.venue?.location?.lat?.toFloat()
                                    , group?.venue?.location?.lng?.toFloat()
                                    , group?.venue?.name, group?.venue?.location?.crossStreet
                                    , group?.venue?.location?.distance.toString()
                                    , group?.venue?.location?.formattedAddress.toString()
                                    , group?.venue?.location?.city
                                    , group?.venue?.categories?.get(0)?.name))
                        }
                    }
                    Completable.create {
                        dataManager.insertVenueModel(venueModel)
                        it.onComplete()
                    }.subscribeOn(schedulersProvider.io())
                            .observeOn(schedulersProvider.ui())
                            .subscribe {
//                                venueModels.value?.addAll(venueModel)
                                venueModels.value = venueModel
                            }

                }, { throwable: Throwable? ->
                    throwable?.printStackTrace()
                })
        )
    }

    fun retrieveData(lat: Float, lng: Float) {

        Timber.d("retrieveData " + lat.toString() + " " + lng.toString())
        compositeDisposable.add(dataManager.getAllVenueByLocationFromDb(
                lat - AppConstants.METER_DISTANCE
                , lng - AppConstants.METER_DISTANCE
                , lat + AppConstants.METER_DISTANCE
                , lng + AppConstants.METER_DISTANCE)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe({
                    venueModels.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    fun getDate(): String {
        val calendar = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.ENGLISH)
        return dateFormat.format(calendar)
    }
}
