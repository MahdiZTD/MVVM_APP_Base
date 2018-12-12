package com.visally.showme.ui.venuedetail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.visally.showme.BR
import com.visally.showme.R
import com.visally.showme.databinding.ActivityVenueDetailBinding
import com.visally.showme.ui.base.BaseActivity
import javax.inject.Inject

class VenueDetailActivity : BaseActivity<ActivityVenueDetailBinding, VenueDetailViewModel>(), VenueDetailNavigator {


    @Inject
    lateinit var venueDetailViewModelFactory: ViewModelProvider.Factory

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_venue_detail
    override val mViewModel: VenueDetailViewModel
        get() = ViewModelProviders.of(this, venueDetailViewModelFactory).get(VenueDetailViewModel::class.java)

    lateinit var mBinding: ActivityVenueDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = viewDataBinding
        mViewModel.setNavigator(this)
    }
}
