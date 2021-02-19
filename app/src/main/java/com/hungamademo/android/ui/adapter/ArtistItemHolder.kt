package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutArtistItemBinding
import com.hungamademo.android.model.BucketContent

class ArtistItemHolder(var binding: LayoutArtistItemBinding, var context: Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketArtistTitle.text = title
            binding.tvBucketArtistTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketArtistTitle.visibility = View.GONE
        }

        if (subTitle.isNotEmpty()) {
            binding.tvBucketArtistSubTitle.text = subTitle
            binding.tvBucketArtistSubTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketArtistSubTitle.visibility = View.GONE
        }

        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_artist))
            .circleCrop().placeholder(context.resources.getDrawable(R.drawable.dummy)).centerCrop()
            .into(binding.ivBucketArtistImage)
    }
}