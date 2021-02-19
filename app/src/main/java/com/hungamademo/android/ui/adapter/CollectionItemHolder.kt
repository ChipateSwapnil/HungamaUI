package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutCollectionItemBinding
import com.hungamademo.android.model.BucketContent

class CollectionItemHolder(var binding: LayoutCollectionItemBinding, var context: Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketCollectionTitle.text = title
            binding.tvBucketCollectionTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketCollectionTitle.visibility = View.GONE
        }

        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_collection))
            .placeholder(context.resources.getDrawable(R.drawable.ic_launcher_background))
            .centerCrop().into(binding.ivBucketCollectionImage)
    }
}