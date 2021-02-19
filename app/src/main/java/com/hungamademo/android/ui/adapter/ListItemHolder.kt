package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutListItemBinding
import com.hungamademo.android.model.BucketContent

class ListItemHolder(var binding: LayoutListItemBinding, var context : Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketListTitle.text = title
            binding.tvBucketListTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketListTitle.visibility = View.GONE
        }


        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_songs)).placeholder(context.resources.getDrawable(R.drawable.ic_launcher_background)).centerCrop().into(binding.ivBucketListImage)
    }
}