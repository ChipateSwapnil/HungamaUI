package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutRectangularMusicItemBinding
import com.hungamademo.android.model.BucketContent
import com.hungamademo.android.utils.ToastUtil

class RectangularMusicItemHolder(
    var binding: LayoutRectangularMusicItemBinding,
    var context: Context
) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketRectMusicTitle.text = title
            binding.tvBucketRectMusicTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketRectMusicTitle.visibility = View.GONE
        }

        if (imageURL.isNotEmpty()) {
            Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_rect_music))
                .placeholder(context.resources.getDrawable(R.drawable.dummy)).centerCrop()
                .into(binding.ivBucketRectMusicImage)
        } else {
            binding.ivBucketRectMusicImage.visibility = View.GONE
        }

        binding.clMainRectMusic.setOnClickListener(View.OnClickListener {
//            ToastUtil.showShortToast(context, "$title is clicked")
        })
    }
}