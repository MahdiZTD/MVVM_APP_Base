package com.visally.showme.ui.venuedetail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.bumptech.glide.Glide
import com.visally.showme.BR
import com.visally.showme.R
import com.visally.showme.databinding.ActivityVenueDetailBinding
import com.visally.showme.infrustructure.data.model.api.venuedetail.VenueDetailResponse
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

    private lateinit var mBinding: ActivityVenueDetailBinding
    private lateinit var venueId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = viewDataBinding
        mViewModel.setNavigator(this)
        venueId = intent.getStringExtra("venueId")
        mViewModel.getVenueDetail(venueId)

    }

    override fun loadVenueDetailData(venueDetailResponse: VenueDetailResponse) {
        Glide.with(this)
                .load(venueDetailResponse.response?.venue?.bestPhoto?.prefix +
                        venueDetailResponse.response?.venue?.bestPhoto?.width +
                        "x"+
                        venueDetailResponse.response?.venue?.bestPhoto?.width +
                venueDetailResponse.response?.venue?.bestPhoto?.suffix)
                .into(mBinding.imgHeader)
        mBinding.txtAddress.text = venueDetailResponse.response?.venue?.location?.address
        mBinding.txtTitle.text = venueDetailResponse.response?.venue?.name
        mBinding.txtLikeCount.text = venueDetailResponse.response?.venue?.likes?.count.toString()
        Glide.with(this)
                .load(venueDetailResponse.response?.venue?.categories?.get(0)?.icon?.prefix +
                        "64" +
                        venueDetailResponse.response?.venue?.categories?.get(0)?.icon?.suffix)
                .into(mBinding.imgCategory)

    }
}
