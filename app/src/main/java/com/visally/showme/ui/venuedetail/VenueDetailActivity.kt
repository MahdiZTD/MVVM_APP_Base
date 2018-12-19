package com.visally.showme.ui.venuedetail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.bumptech.glide.Glide
import com.visally.showme.BR
import com.visally.showme.R
import com.visally.showme.infrustructure.data.model.api.venuedetail.VenueDetailResponse
import com.visally.showme.ui.base.BaseActivity
import javax.inject.Inject
import android.content.Intent
import android.net.Uri
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.view.animation.DecelerateInterpolator
import com.visally.showme.databinding.ActivityVenueDetailPreLoadBinding


class VenueDetailActivity : BaseActivity<ActivityVenueDetailPreLoadBinding, VenueDetailViewModel>(), VenueDetailNavigator {


    @Inject
    lateinit var venueDetailViewModelFactory: ViewModelProvider.Factory

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_venue_detail_pre_load
    override val mViewModel: VenueDetailViewModel
        get() = ViewModelProviders.of(this, venueDetailViewModelFactory).get(VenueDetailViewModel::class.java)

    private lateinit var mBinding: ActivityVenueDetailPreLoadBinding
    private lateinit var venueId: String
    private lateinit var rootView: ConstraintLayout
    private val pageLoaded = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = viewDataBinding
        mViewModel.setNavigator(this)
        rootView = mBinding.root as ConstraintLayout
        venueId = intent.getStringExtra("venueId")
        mViewModel.getVenueDetail(venueId)
    }

    override fun loadVenueDetailData(venueDetailResponse: VenueDetailResponse) {
        showResources()
        mBinding.txtAddress.text = venueDetailResponse.response?.venue?.location?.address
        mBinding.txtTitle.text = venueDetailResponse.response?.venue?.name
        mBinding.txtLikeCount.text = venueDetailResponse.response?.venue?.likes?.count.toString()
        mBinding.txtTip.text = venueDetailResponse.response?.venue?.tips?.groups?.get(0)?.items?.get(0)?.text
        mBinding.txtUserName.text = venueDetailResponse.response?.venue?.tips?.groups?.get(0)?.items?.get(0)?.user?.firstName

        Glide.with(this)
                .load(venueDetailResponse.response?.venue?.tips?.groups?.get(0)?.items?.get(0)?.user?.photo?.prefix +
                        "128x128" + venueDetailResponse.response?.venue?.tips?.groups?.get(0)?.items?.get(0)?.user?.photo?.suffix)
                .into(mBinding.imgAvatar)

        Glide.with(this)
                .load(venueDetailResponse.response?.venue?.categories?.get(0)?.icon?.prefix +
                        "64" +
                        venueDetailResponse.response?.venue?.categories?.get(0)?.icon?.suffix)
                .into(mBinding.imgCategory)

        Glide.with(this)
                .load(venueDetailResponse.response?.venue?.bestPhoto?.prefix +
                        venueDetailResponse.response?.venue?.bestPhoto?.width +
                        "x" +
                        venueDetailResponse.response?.venue?.bestPhoto?.width +
                        venueDetailResponse.response?.venue?.bestPhoto?.suffix)
                .into(mBinding.imgHeader)
    }

    fun showResources(){
        pageLoaded.clone(this, R.layout.activity_venue_detail)
        val transition = ChangeBounds()
        transition.interpolator = DecelerateInterpolator()
        transition.duration = 1000
        TransitionManager.beginDelayedTransition(rootView,transition)
        val constraint = pageLoaded
        constraint.applyTo(rootView)
    }
    override fun openMap(latitude:String?,longitude:String?,placeName:String?) {
        val intent = Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=$latitude,$longitude ($placeName)"))
        startActivity(intent)
    }

    override fun callPlace(tel: String?) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$tel")
        startActivity(intent)
    }
}
