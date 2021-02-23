package com.hungamademo.android.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hungamademo.android.base.BaseBucketItemHolder
import com.hungamademo.android.databinding.*
import com.hungamademo.android.model.BucketContent
import com.hungamademo.android.utils.Constants

class BucketItemAdapter(
    var bucketContentList: ArrayList<BucketContent>,
    var context: Context,
    var type: Int
) : RecyclerView.Adapter<BaseBucketItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBucketItemHolder {
        return when (type) {
            Constants.ITEM_TYPE_STATUS -> {
                val binding: LayoutStatusItemBinding = LayoutStatusItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                StatusItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_LIST -> {
                val binding: LayoutListItemBinding = LayoutListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ListItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_MUSIC, Constants.ITEM_TYPE_PODCAST, Constants.ITEM_TYPE_TRENDING -> {
                val binding: LayoutMusicItemBinding = LayoutMusicItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MusicItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_RECT_MUSIC -> {
                val binding: LayoutRectangularMusicItemBinding = LayoutRectangularMusicItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                RectangularMusicItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_COLLECTION -> {
                val binding: LayoutCollectionItemBinding = LayoutCollectionItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CollectionItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_VIDEO, Constants.ITEM_TYPE_MUSIC_VIDEO -> {
                val binding: LayoutVideoItemBinding = LayoutVideoItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                VideoItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_SONGS -> {
                val binding: LayoutSongItemBinding = LayoutSongItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                SongItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_ARTIST -> {
                val binding: LayoutArtistItemBinding = LayoutArtistItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ArtistItemHolder(binding, context)
            }
            Constants.ITEM_TYPE_MOVIE -> {
                val binding: LayoutMovieItemBinding = LayoutMovieItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MovieItemHolder(binding, context)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return bucketContentList.size
    }

    override fun onBindViewHolder(holder: BaseBucketItemHolder, position: Int) {
        holder.bind(bucketContentList[position])
    }

}