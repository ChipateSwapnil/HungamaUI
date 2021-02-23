package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutMusicItemBinding
import com.hungamademo.android.model.BucketContent
import com.hungamademo.android.utils.ToastUtil

class MusicItemHolder(var binding: LayoutMusicItemBinding, var context: Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketMusicTitle.text = title
            binding.tvBucketMusicTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketMusicTitle.visibility = View.GONE
        }

        if (subTitle.isNotEmpty()) {
            binding.tvBucketMusicSubTitle.text = subTitle
            binding.tvBucketMusicSubTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketMusicSubTitle.visibility = View.GONE
        }

        Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_radio))
            .placeholder(context.resources.getDrawable(R.drawable.dummy)).centerCrop()
            .into(binding.ivBucketMusicImage)

        binding.clMainMusic.setOnClickListener(View.OnClickListener {
//            ToastUtil.showShortToast(context,"$title is clicked")
        })

    }
}