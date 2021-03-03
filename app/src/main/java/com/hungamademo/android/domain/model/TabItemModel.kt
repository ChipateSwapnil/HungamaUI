package com.hungamademo.android.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TabItemModel(
    @SerializedName("code")
    @Expose
    var code: Int,
    @SerializedName("data")
    @Expose
    var dataList: List<TabData>,
    @SerializedName("message")
    @Expose
    var message: String
)