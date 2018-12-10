package com.visally.showme.ui.venuelist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.visally.showme.databinding.ItemVenueListBinding
import com.visally.showme.infrustructure.data.model.db.VenueModel
import com.visally.showme.ui.base.BaseViewHolder

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 12/8/2018.
 */
class VenueRecyclerViewAdapter(val mVenueList: MutableList<VenueModel>) : RecyclerView.Adapter<BaseViewHolder>() {
    val mClickListener: VenueRecyclerListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseViewHolder {
        val blogViewBinding = ItemVenueListBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return VenueViewHolder(blogViewBinding)
    }

    override fun getItemCount(): Int {
        return mVenueList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }


    fun addItems(venueList: List<VenueModel>) {
        mVenueList.addAll(venueList.distinct())
        notifyDataSetChanged()
    }

    fun clearItems() {
        mVenueList.clear()
//        notifyDataSetChanged()
    }

    inner class VenueViewHolder(private val mBinding: ItemVenueListBinding) : BaseViewHolder(mBinding.root), VenueItemViewModel.VenueItemClickListener {

        private var mVenueItemViewModel: VenueItemViewModel? = null

        override fun onBind(position: Int) {
            val venue = mVenueList[position]
            mVenueItemViewModel = VenueItemViewModel(venue, this)
            mBinding.venueItem = mVenueItemViewModel
            mBinding.txtVenueItemName.text = venue.name
            mBinding.txtVenueItemAddress.text = venue.formattedAddress
            mBinding.txtVenueItemDistance.text = venue.distance
            mBinding.txtVenueItemCategory.text = venue.category
            mBinding.executePendingBindings()
        }

        override fun onItemClick(id: String) {
            mClickListener?.onItemClick(id)
        }
    }

    interface VenueRecyclerListener{
        fun onItemClick(id:String)
    }

}