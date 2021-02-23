package com.hungamademo.android.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hungamademo.android.model.Bucket
import com.hungamademo.android.utils.JsonReaderUtils
import com.hungamademo.android.utils.LogUtils

class BucketItemViewModel : ViewModel() {

    var bucket = MutableLiveData<Bucket>()

    fun getBucketData(
        context: Context,
        bottomSheetSelected: String,
        tabSelected: String
    ): LiveData<Bucket> {
        var jsonFileString =""
        if (bottomSheetSelected.equals("Discover") && tabSelected.equals("All"))
            jsonFileString =
                JsonReaderUtils.getJsonDataFromAsset(context, "discover.json").toString()
        else if (bottomSheetSelected.equals("Music") && tabSelected.equals("All"))
            jsonFileString = JsonReaderUtils.getJsonDataFromAsset(context, "music.json").toString()
        LogUtils.LOGI("data", jsonFileString)
        val gson = Gson()
        val bucketModelType = object : TypeToken<Bucket>() {}.type
        bucket.value = gson.fromJson(jsonFileString, bucketModelType)
        return bucket
    }

}