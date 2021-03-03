package com.hungamademo.android.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hungamademo.android.domain.model.Bucket
import com.hungamademo.android.domain.repository.BucketRepository
import com.hungamademo.android.utils.JsonReaderUtils
import com.hungamademo.android.utils.LogUtils

class BucketRepositoryImpl : BucketRepository {
    override suspend fun getBucketItems(
        context: Context,
        bottomSheetSelected: String,
        tabSelected: String
    ): Bucket {
        var jsonFileString = ""
        if (bottomSheetSelected.equals("Discover") && tabSelected.equals("All"))
            jsonFileString =
                JsonReaderUtils.getJsonDataFromAsset(context, "discover.json").toString()
        else if (bottomSheetSelected.equals("Music") && tabSelected.equals("All"))
            jsonFileString = JsonReaderUtils.getJsonDataFromAsset(context, "music.json").toString()
        LogUtils.LOGI("data", jsonFileString)
        val gson = Gson()
        val bucketModelType = object : TypeToken<Bucket>() {}.type
        return if (jsonFileString.isNotEmpty())
            gson.fromJson(jsonFileString, bucketModelType)
        else
            Bucket(404, arrayListOf(),"No data found")
    }

}