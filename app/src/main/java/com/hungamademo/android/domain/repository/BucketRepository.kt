package com.hungamademo.android.domain.repository

import android.content.Context
import com.hungamademo.android.domain.model.Bucket


interface BucketRepository {
    suspend fun getBucketItems(
        context: Context,
        bottomSheetSelected: String,
        tabSelected: String
    ): Bucket
}