package com.hungamademo.android.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TabData(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("title")
    @Expose
    var title: String
)