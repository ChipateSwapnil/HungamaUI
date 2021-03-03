package com.hungamademo.android.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hungamademo.android.data.repository.BucketRepositoryImpl
import com.hungamademo.android.domain.model.Bucket
import com.hungamademo.android.domain.usecase.GetBucketItemUseCase

class BucketItemViewModel : ViewModel() {

    private val TAG: String = BucketItemViewModel::class.java.simpleName
    var bucket = MutableLiveData<Bucket>()

    fun getBucketData(
        context: Context,
        bottomSheetSelected: String,
        tabSelected: String
    ) {
        var getBucketItemUseCase =
            GetBucketItemUseCase(BucketRepositoryImpl(), context, bottomSheetSelected, tabSelected)

        getBucketItemUseCase.execute {
            onComplete {
                Log.d(TAG, it.toString())
                bucket.value = it
            }

            onError { throwable ->
            }

            onCancel {

            }
        }
    }

}