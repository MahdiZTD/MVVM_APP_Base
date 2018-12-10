package com.visally.showme.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N> constructor(schedulerProvider: SchedulersProvider, dataManager: DataManager):ViewModel() {

    val mIsLoading = ObservableBoolean(false)
    var compositeDisposable:CompositeDisposable= CompositeDisposable()
    lateinit var mNavigator: WeakReference<N>

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}