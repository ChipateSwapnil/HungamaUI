package com.hungamademo.android.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.hungamademo.android.model.BucketContent

abstract class BaseBucketItemHolder(viewBinding: ViewBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {
    lateinit var title: String
    lateinit var subTitle: String
    lateinit var imageURL: String
    var id = -1

    open fun bind(bucketContent: BucketContent) {
        title = bucketContent.title
        subTitle = bucketContent.subtitle
        imageURL = bucketContent.image
        id = bucketContent.id
    }
}