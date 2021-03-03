package com.hungamademo.android.domain.usecase

import android.content.Context
import com.architecture.clean.domain.usecase.base.UseCase
import com.hungamademo.android.domain.model.Bucket
import com.hungamademo.android.domain.model.TabItemModel
import com.hungamademo.android.domain.repository.BucketRepository


class GetBucketItemUseCase(
    private val bucketRepository: BucketRepository,
    val context: Context,
    private val bottomSheetSelected: String,
    private val tabSelected: String
) : UseCase<Bucket>() {
    override suspend fun executeOnBackground(): Bucket {
        return bucketRepository.getBucketItems(context, bottomSheetSelected, tabSelected)
    }
}