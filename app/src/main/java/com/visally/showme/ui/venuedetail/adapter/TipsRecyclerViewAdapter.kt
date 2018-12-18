package com.visally.showme.ui.venuedetail.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.visally.showme.databinding.ItemTipBinding
import com.visally.showme.ui.base.BaseViewHolder
import com.visally.showme.ui.venuedetail.model.TipModel

class TipsRecyclerViewAdapter(val mTipsList: MutableList<TipModel>,val mContext:Context) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BaseViewHolder {
        val tipViewBinding = ItemTipBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return TipViewHolder(tipViewBinding)
    }

    override fun getItemCount(): Int {
        return mTipsList.size
    }

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
    }

    inner class TipViewHolder(val mBinding: ItemTipBinding):BaseViewHolder(mBinding.root){

        private var mItemTipItemViewModel:TipItemViewModel? = null

        override fun onBind(position: Int) {
            val mTip = mTipsList[position]
            this.mItemTipItemViewModel = TipItemViewModel(mTip)
            mBinding.itemTip = mItemTipItemViewModel
            mBinding.txtItemTipMessage.text = mTip.message
            mBinding.txtItemTipUserName.text = mTip.userName
            Glide.with(mContext)
                    .load(mTip.imageUrl)
                    .into(mBinding.imgItemTipUserAvatar)
            mBinding.executePendingBindings()
        }

    }
}