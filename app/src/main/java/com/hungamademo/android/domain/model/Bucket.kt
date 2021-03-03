package com.hungamademo.android.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Bucket(
    @SerializedName("code")
    @Expose
    val code: Int,
    @SerializedName("data")
    @Expose
    val dataList: List<BucketData>,
    @SerializedName("message")
    @Expose
    val message: String
)