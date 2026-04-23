package com.example.makersassignment.data.home.datasourceimpl

import com.example.makersassignment.core.common.exception.ApiException
import com.example.makersassignment.data.home.datasource.GalleryDataSource
import com.example.makersassignment.data.home.dto.response.GalleryImageResponseDto
import com.example.makersassignment.data.home.service.GalleryService
import javax.inject.Inject


class GalleryDataSourceImpl @Inject constructor(
    private val service: GalleryService
) : GalleryDataSource {
    override suspend fun getImages(page: Int, limit: Int): List<GalleryImageResponseDto> {
        val response = service.getImages(page, limit)

        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw ApiException.HttpError(response.code(), response.message())
        }
    }
}
