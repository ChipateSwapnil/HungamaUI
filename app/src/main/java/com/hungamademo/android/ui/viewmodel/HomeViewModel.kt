package com.hungamademo.android.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hungamademo.android.model.TabItemModel
import com.hungamademo.android.utils.JsonReaderUtils
import com.hungamademo.android.utils.LogUtils


class HomeViewModel : ViewModel() {

    var tabItemsModel = MutableLiveData<TabItemModel>()

    fun getTabItems(bottomTabSelected: String, context: Context): MutableLiveData<TabItemModel> {
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
        tabItemsModel.value = gson.fromJson(jsonFileString, tabItemModelType)
        return tabItemsModel
    }
}