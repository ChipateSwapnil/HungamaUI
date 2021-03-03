package com.hungamademo.android.presentation.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hungamademo.android.base.BaseViewHolder
import com.hungamademo.android.databinding.LayoutMainRecylerviewItemBinding
import com.hungamademo.android.domain.model.BucketContent
import com.hungamademo.android.domain.model.BucketData
import com.hungamademo.android.utils.Constants


class BucketHolder(var binding: LayoutMainRecylerviewItemBinding, var context: Context) :
    BaseViewHolder<BucketData>(binding) {

    override fun bind(bucketData: BucketData) {
        val title = bucketData.title
        val subTitle = bucketData.subtitle
        val id = bucketData.id
        val type = bucketData.type
        val showMore = bucketData.showmore

        if (showMore) {
            binding.ivBucketShowMore.visibility = View.VISIBLE
        } else {
            binding.ivBucketShowMore.visibility = View.GONE
        }

        if (title.isNotEmpty()) {
            binding.tvBucketTitle.text = title
            binding.tvBucketTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketTitle.visibility = View.GONE
            binding.ivBucketShowMore.visibility = View.GONE
        }


        if (subTitle.isNotEmpty()) {
            binding.tvBucketSubTitle.text = subTitle
            binding.tvBucketSubTitle.visibility = View.VISIBLE
        } else {
            binding.tvBucketSubTitle.visibility = View.GONE
        }

        val bucketAdapter =
            BucketItemAdapter(bucketData.bucketContents as ArrayList<BucketContent>, context, type)

        //set the RecyclerView for Buckets
        binding.rvBucketItems.layoutManager = getLayoutManger(type)
        binding.rvBucketItems.adapter = bucketAdapter

        if (type == Constants.ITEM_TYPE_STATUS) {
            binding.viewStatusDivide.visibility = View.VISIBLE
        } else {
            binding.viewStatusDivide.visibility = View.GONE
        }



    }

    fun getLayoutManger(
        type: Int
    ): RecyclerView.LayoutManager {
        return when (type) {
            Constants.ITEM_TYPE_PODCAST, Constants.ITEM_TYPE_TRENDING, Constants.ITEM_TYPE_MUSIC_VIDEO, Constants.ITEM_TYPE_MOVIE -> {
                getGridLayoutManager(2)
            }
            Constants.ITEM_TYPE_SONGS -> {
                getGridLayoutManager(5)
            }
            Constants.ITEM_TYPE_LIST , Constants.ITEM_TYPE_RECT_MUSIC-> {
                getGridLayoutManager(3)
            }
            Constants.ITEM_TYPE_STATUS, Constants.ITEM_TYPE_MUSIC, Constants.ITEM_TYPE_COLLECTION, Constants.ITEM_TYPE_VIDEO, Constants.ITEM_TYPE_ARTIST -> {
                getLinearLayoutManager()
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    private fun getLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun getGridLayoutManager(numberOfRows: Int): LinearLayoutManager {
        return GridLayoutManager(context, numberOfRows, GridLayoutManager.HORIZONTAL, false);
    }
}