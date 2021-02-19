package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hungamademo.android.databinding.LayoutMainRecylerviewItemBinding
import com.hungamademo.android.model.BucketData

class BucketAdapter(var buckets: ArrayList<BucketData>, var context: Context) :
    RecyclerView.Adapter<BucketHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BucketHolder {
        val binding: LayoutMainRecylerviewItemBinding = LayoutMainRecylerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BucketHolder(binding,context)
    }

    override fun getItemCount(): Int {
        return buckets.size
    }

    override fun onBindViewHolder(holder: BucketHolder, position: Int) {
        holder.bind(buckets[position])
    }

}