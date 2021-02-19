package com.hungamademo.android.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BucketData(
    @SerializedName("contents")
    @Expose
    val bucketContents: List<BucketContent>,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("showmore")
    @Expose
    val showmore: Boolean,
    @SerializedName("subtitle")
    @Expose
    val subtitle: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("type")
    @Expose
    val type: Int
)