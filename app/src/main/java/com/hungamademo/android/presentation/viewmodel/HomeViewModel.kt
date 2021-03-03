package com.hungamademo.android.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hungamademo.android.data.repository.TabRepositoryImpl
import com.hungamademo.android.domain.model.TabItemModel
import com.hungamademo.android.domain.usecase.GetTabItemUseCase


class HomeViewModel : ViewModel() {

    private val TAG: String = HomeViewModel::class.java.simpleName
    var tabItemsModel = MutableLiveData<TabItemModel>()

    fun getTabItems(bottomTabSelected: String, context: Context) {
        var getTabItemUseCase = GetTabItemUseCase(TabRepositoryImpl(), bottomTabSelected, context)

        getTabItemUseCase.execute {
            onComplete {
                Log.d(TAG, it.toString())
                tabItemsModel.value = it
            }

            onError { throwable ->
            }

            onCancel {

            }
        }
    }
}