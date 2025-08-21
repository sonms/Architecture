package com.example.makersassignment.data.repositoryimpl.remote

import com.example.makersassignment.data.datasource.remote.GalleryDataSource
import com.example.makersassignment.domain.entity.GalleryImageEntity
import com.example.makersassignment.domain.repository.GalleryRepository
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val dataSource: GalleryDataSource
) : GalleryRepository {
    override suspend fun getGalleryImageList(
        page: Int,
        limit: Int
    ): Result<List<GalleryImageEntity>> = runCatching {
        dataSource.getImages(page, limit).map { it.toDomain() }
    }
}