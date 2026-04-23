package com.example.makersassignment.data.home.repositoryimpl

import com.example.makersassignment.domain.home.entity.GalleryImageEntity
import com.example.makersassignment.domain.home.repository.GalleryRepository
import com.example.makersassignment.data.home.datasource.GalleryDataSource
import javax.inject.Inject

internal class GalleryRepositoryImpl @Inject constructor(
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
