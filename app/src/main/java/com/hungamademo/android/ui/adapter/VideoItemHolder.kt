package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutListItemBinding
import com.hungamademo.android.databinding.LayoutMusicItemBinding
import com.hungamademo.android.databinding.LayoutVideoItemBinding
import com.hungamademo.android.model.BucketContent

class VideoItemHolder(var binding: LayoutVideoItemBinding, var context : Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketVideoTitle.text = title
            binding.tvBucketVideoTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketVideoTitle.visibility = View.GONE
        }

        if (subTitle.isNotEmpty()) {
            binding.tvBucketVideoSubTitle.text = subTitle
            binding.tvBucketVideoSubTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketVideoSubTitle.visibility = View.GONE
        }

        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_video)).placeholder(context.resources.getDrawable(R.drawable.ic_launcher_background)).centerCrop().into(binding.ivBucketVideoImage)
    }
}