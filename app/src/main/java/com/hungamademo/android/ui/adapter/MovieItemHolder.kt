package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutMovieItemBinding
import com.hungamademo.android.model.BucketContent

class MovieItemHolder(var binding: LayoutMovieItemBinding, var context: Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketMovieTitle.text = title
            binding.tvBucketMovieTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketMovieTitle.visibility = View.GONE
        }

        if (subTitle.isNotEmpty()) {
            binding.tvBucketMovieSubTitle.text = subTitle
            binding.tvBucketMovieSubTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketMovieSubTitle.visibility = View.GONE
        }

        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_movie))
            .placeholder(context.resources.getDrawable(R.drawable.dummy))
            .centerCrop().into(binding.ivBucketMovieImage)
    }
}