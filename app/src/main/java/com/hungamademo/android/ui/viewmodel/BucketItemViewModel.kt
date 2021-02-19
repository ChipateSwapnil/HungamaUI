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

    fun getBucketData(context: Context): LiveData<Bucket> {
        val jsonFileString = JsonReaderUtils.getJsonDataFromAsset(context, "discover.json")
        LogUtils.LOGI("data", jsonFileString)
        val gson = Gson()
        val bucketModelType = object : TypeToken<Bucket>() {}.type
        bucket.value = gson.fromJson(jsonFileString, bucketModelType)
        return bucket
    }

}