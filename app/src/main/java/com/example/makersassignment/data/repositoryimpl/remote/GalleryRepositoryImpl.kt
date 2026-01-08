package com.example.makersassignment.data.repositoryimpl.remote

import com.example.makersassignment.data.datasource.remote.GalleryDataSource
import com.example.makersassignment.domain.entity.GalleryImageEntity
import com.example.makersassignment.domain.repository.GalleryRepository
import timber.log.Timber
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val dataSource: GalleryDataSource
) : GalleryRepository {
    private var prefetchBuffer: Pair<Int, List<GalleryImageEntity>>? = null

    override suspend fun getGalleryImageList(
        page: Int,
        limit: Int
    ): Result<List<GalleryImageEntity>> = runCatching {
        val bufferedData = prefetchBuffer

        if (bufferedData != null && bufferedData.first == page) {
            prefetchBuffer = null
            Timber.d("prefetched data -> 스킵")
            return Result.success(bufferedData.second)
        }

        return try {
            val response = dataSource.getImages(page, limit)
            val entities = response.map { it.toDomain() }
            prefetchBuffer = page to entities

            Result.success(entities)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
