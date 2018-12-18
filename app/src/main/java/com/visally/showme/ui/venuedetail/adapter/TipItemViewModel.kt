package com.visally.showme.ui.venuedetail.adapter

import android.databinding.ObservableField
import com.visally.showme.ui.venuedetail.model.TipModel


class TipItemViewModel(val mTip:TipModel) {
    private val tipMessage: ObservableField<String> = ObservableField(mTip.message!!)
    private val tipUserName: ObservableField<String> = ObservableField(mTip.userName!!)
    private val tipAvatar: ObservableField<String> = ObservableField(mTip.imageUrl!!)
}