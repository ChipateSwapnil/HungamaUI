package com.hungamademo.android.domain.repository

import android.content.Context
import com.hungamademo.android.domain.model.TabItemModel

interface TabRepository {
    suspend fun getTabItems(bottomTabSelected: String, context: Context): TabItemModel
}