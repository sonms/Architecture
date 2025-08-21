package com.example.makersassignment.data.repositoryimpl

import com.example.makersassignment.core.common.exception.ApiException
import com.example.makersassignment.data.datasource.GalleryDataSource
import com.example.makersassignment.domain.entity.GalleryImageEntity
import com.example.makersassignment.domain.repository.GalleryRepository
import timber.log.Timber
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val dataSource: GalleryDataSource
) : GalleryRepository {
    override suspend fun getGalleryImageList(
        page: Int,
        limit: Int
    ): Result<List<GalleryImageEntity>> = runCatching {
        val response = dataSource.getImages(page, limit)

        Timber.d("response : $response")

        if (response.isSuccessful) {
            response.body()?.map { it.toDomain() } ?: emptyList()
        } else {
            throw ApiException.HttpError(response.code(), response.message())
        }
    }
}