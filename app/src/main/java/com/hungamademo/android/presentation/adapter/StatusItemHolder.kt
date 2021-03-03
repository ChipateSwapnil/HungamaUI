package com.hungamademo.android.presentation.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutStatusItemBinding
import com.hungamademo.android.domain.model.BucketContent

class StatusItemHolder(var binding: LayoutStatusItemBinding, var context: Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketStatusTitle.text = title
            binding.tvBucketStatusTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketStatusTitle.visibility = View.GONE
        }

        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_artist))
            .circleCrop()
            .placeholder(context.resources.getDrawable(R.drawable.dummy))
            .centerCrop().into(binding.ivBucketStatusImage)

        binding.clMainStatus.setOnClickListener(View.OnClickListener {
//            ToastUtil.showShortToast(context,"$title is clicked")
        })
    }
}