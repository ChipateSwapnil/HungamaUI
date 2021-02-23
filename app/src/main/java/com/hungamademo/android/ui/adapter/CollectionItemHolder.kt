package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.hungamademo.android.R
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.LayoutCollectionItemBinding
import com.hungamademo.android.model.BucketContent
import com.hungamademo.android.utils.ToastUtil

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
            .placeholder(context.resources.getDrawable(R.drawable.dummy))
            .centerCrop().into(binding.ivBucketCollectionImage)

        binding.clCollection.setOnClickListener(View.OnClickListener {
//            ToastUtil.showShortToast(context, "$title is clicked")
        })
    }
}