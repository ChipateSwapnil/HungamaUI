package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutSongItemBinding
import com.hungamademo.android.model.BucketContent
import com.hungamademo.android.utils.ToastUtil

class SongItemHolder(var binding: LayoutSongItemBinding, var context: Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketSongTitle.text = title
            binding.tvBucketSongTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketSongTitle.visibility = View.GONE
        }

        if (subTitle.isNotEmpty()) {
            binding.tvBucketSongSubTitle.text = subTitle
            binding.tvBucketSongSubTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketSongSubTitle.visibility = View.GONE
        }

        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_songs))
            .placeholder(context.resources.getDrawable(R.drawable.dummy)).centerCrop()
            .into(binding.ivBucketSongImage)

        binding.clMainSong.setOnClickListener(View.OnClickListener {
//            ToastUtil.showShortToast(context,"$title is clicked")
        })
    }
}