package com.visally.showme.ui.venuedetail

import com.visally.showme.infrustructure.data.DataManager
import com.visally.showme.infrustructure.utils.rx.SchedulersProvider
import com.visally.showme.ui.base.BaseViewModel

class VenueDetailViewModel constructor(val dataManager: DataManager, val schedulersProvider: SchedulersProvider) : BaseViewModel<VenueDetailNavigator>(schedulersProvider, dataManager) {
}