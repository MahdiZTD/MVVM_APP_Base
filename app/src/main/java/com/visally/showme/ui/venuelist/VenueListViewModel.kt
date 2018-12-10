package com.visally.showme.ui.venuelist

import android.arch.lifecycle.LiveData
import android.databinding.Observable
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.data.model.api.searchvenue.SearchVenueResponse
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.utils.AppConstants
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import com.visally.showme.ui.base.BaseViewModel
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*


class VenueListViewModel constructor(val dataManager: DataManager, val schedulersProvider: SchedulersProvider) : BaseViewModel<VenueListNavigator>(schedulersProvider, dataManager) {
    val disposable = CompositeDisposable()
    var venueModels: LiveData<List<VenueModel>> = dataManager.getAllVenueByLocationFromDb(76.75672f,72.45479f)
    var venueObservableArrayList: ObservableList<VenueModel> = ObservableArrayList()

    fun getNearVenue(lat: Float, lng: Float, page: Int) {
        val location = lat.toString() + "," + lng.toString()
        disposable.add(dataManager.getNearVenueByLocationFromApi(location,
                AppConstants.CLIET_ID,
                AppConstants.CLIET_SECRET, getDate(),
                AppConstants.PAGE_LIMIT,
                page * AppConstants.PAGE_LIMIT)
                .subscribeOn(schedulersProvider.io())
                .observeOn(schedulersProvider.ui())
                .subscribe { searchVenueModel: SearchVenueResponse? ->
                    val venueModel: MutableList<VenueModel> = mutableListOf()
                    searchVenueModel?.response?.groups?.forEach {
                        it?.items?.forEach { it ->
                            venueModel.add(VenueModel(it?.venue?.id.toString()
                                    , it?.venue?.location?.lat?.toFloat()
                                    , it?.venue?.location?.lng?.toFloat()
                                    , it?.venue?.name, it?.venue?.location?.crossStreet
                                    , it?.venue?.location?.distance.toString()
                                    , it?.venue?.location?.formattedAddress.toString()
                                    , it?.venue?.location?.city
                                    , it?.venue?.categories?.get(0)?.name))
                        }
                    }

                    Completable.create {
                        dataManager.insertVenueModel(venueModel)
                        it.onComplete()
                    }.subscribeOn(schedulersProvider.io())
                            .observeOn(schedulersProvider.ui())
                            .subscribe()
                }
        )
    }

    fun getDate(): String {
        val calendar = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.ENGLISH)
        return dateFormat.format(calendar)
    }
}
