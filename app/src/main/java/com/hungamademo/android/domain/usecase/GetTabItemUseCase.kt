package com.hungamademo.android.domain.usecase

import android.content.Context
import com.architecture.clean.domain.usecase.base.UseCase
import com.hungamademo.android.domain.model.TabItemModel
import com.hungamademo.android.domain.repository.TabRepository


class GetTabItemUseCase(
    private val tabRepository: TabRepository,
    private val bottomTabSelected: String,
    val context: Context
) : UseCase<TabItemModel>() {
    override suspend fun executeOnBackground(): TabItemModel {
        return tabRepository.getTabItems(bottomTabSelected, context)
    }
}