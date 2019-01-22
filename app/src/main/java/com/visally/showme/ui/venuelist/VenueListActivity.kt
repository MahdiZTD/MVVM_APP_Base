package com.visally.showme.ui.venuelist

import android.Manifest
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation
import com.visally.showme.BR
import com.visally.showme.R
import com.visally.showme.databinding.ActivityVenueListBinding
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.infrustructure.utils.EndlessRecyclerOnScrollListener
import com.visally.showme.ui.base.BaseActivity
import com.visally.showme.ui.venuedetail.VenueDetailActivity
import com.visally.showme.ui.venuelist.adapter.VenueRecyclerViewAdapter
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


class VenueListActivity : BaseActivity<ActivityVenueListBinding, VenueListViewModel>(), VenueListNavigator, VenueRecyclerViewAdapter.VenueRecyclerListener {

    @Inject
    lateinit var mLayoutManager: LinearLayoutManager
    @Inject
    lateinit var mVenueAdapter: VenueRecyclerViewAdapter
    @Inject
    lateinit var venueListViewModelFactory: ViewModelProvider.Factory


    override val bindingVariable: Int
        get() = BR.vm
    override val layoutId: Int
        get() = R.layout.activity_venue_list
    override val mViewModel: VenueListViewModel
        get() = ViewModelProviders.of(this, venueListViewModelFactory).get(VenueListViewModel::class.java)


    private lateinit var mBinding: ActivityVenueListBinding
    private val disposable: CompositeDisposable = CompositeDisposable()

    private var page: Int = 0
    var mAddress: Address? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = viewDataBinding
        mViewModel.setNavigator(this)
        listenForLocationChanged()
        setUpVenueRecyclerView()
        setVenueList()
    }

    private fun setUpVenueRecyclerView() {
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mBinding.rvVenue.layoutManager = mLayoutManager
        mBinding.rvVenue.itemAnimator = DefaultItemAnimator()
        mVenueAdapter.mClickListener =this 
        mBinding.rvVenue.adapter = mVenueAdapter
        mBinding.rvVenue.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                Timber.d("LOAD_MORE")
                if (mAddress != null) {
                    mViewModel.getNearVenue(mAddress!!.latitude.toFloat(), mAddress!!.longitude.toFloat(),++page)
                }
            }
        })
    }

    private fun setVenueList() {
        mViewModel.mVenueModels.observe(this, Observer<MutableList<VenueModel>> {
            if (it != null) {
                Timber.d(it.size.toString())
                mViewModel.venueObservableArrayList.addAll(it)
                mViewModel.venueObservableArrayList.sortWith(compareBy { v -> v.distance!!.toInt() })
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                listenForLocationChanged()
            }
        }
    }

    private fun listenForLocationChanged() {
        val rxLocation = RxLocation(this)
        val locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setSmallestDisplacement(100f)
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            disposable.add(rxLocation.location().updates(locationRequest)
                    .flatMap<Address> { location -> rxLocation.geocoding().fromLocation(location).toObservable() }
                    .subscribe ({ address ->
                        mAddress = address
                        mViewModel.getNearVenue(address.latitude.toFloat(), address.longitude.toFloat(), page)
                    },{
                        throwable: Throwable? -> throwable?.printStackTrace()
                    })
            )
            disposable.add(rxLocation.location().lastLocation().subscribe({
                mViewModel.retrieveData(it.latitude.toFloat(),it.longitude.toFloat())
            },{
                throwable: Throwable? -> throwable?.printStackTrace()
            }))
        } else {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    1000)
        }
    }

    override fun onItemClick(id: String) {
        val  intent = Intent(this , VenueDetailActivity::class.java).apply {
            putExtra("venueId" , id)
        }
        startActivity(intent)
    }

}
