package com.hungamademo.android.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hungamademo.android.domain.model.TabItemModel
import com.hungamademo.android.domain.repository.TabRepository
import com.hungamademo.android.utils.JsonReaderUtils
import com.hungamademo.android.utils.LogUtils

class TabRepositoryImpl : TabRepository {
    override suspend fun getTabItems(bottomTabSelected: String, context: Context): TabItemModel {
        var jsonFileString = ""
        if (bottomTabSelected.equals("Music")) {
            jsonFileString =
                JsonReaderUtils.getJsonDataFromAsset(context, "musicTabItem.json")
                    .toString()
        } else
            jsonFileString =
                JsonReaderUtils.getJsonDataFromAsset(context, "tabitem.json").toString()
        LogUtils.LOGI("data", jsonFileString)
        val gson = Gson()
        val tabItemModelType = object : TypeToken<TabItemModel>() {}.type
        return gson.fromJson(jsonFileString, tabItemModelType)
    }
}