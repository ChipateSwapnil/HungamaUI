package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.Gravity
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutListItemBinding
import com.hungamademo.android.model.BucketContent
import com.hungamademo.android.utils.ToastUtil

class ListItemHolder(var binding: LayoutListItemBinding, var context: Context) :
    BaseBucketItemHolder(binding) {

    override fun bind(bucketContent: BucketContent) {
        super.bind(bucketContent)
        if (title.isNotEmpty()) {
            binding.tvBucketListTitle.text = title
            binding.tvBucketListTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketListTitle.visibility = View.GONE
        }

        if(imageURL.isNotEmpty()) {
            Glide.with(context).load(context.resources.getDrawable(R.drawable.dummy_songs))
                .placeholder(context.resources.getDrawable(R.drawable.dummy)).centerCrop()
                .into(binding.ivBucketListImage)
        }else{
            binding.ivBucketListImage.visibility = View.GONE
            binding.tvBucketListTitle.gravity = Gravity.CENTER
        }

        binding.cvMainList.setOnClickListener(View.OnClickListener {
//            ToastUtil.showShortToast(context,"$title is clicked")
        })
    }
}