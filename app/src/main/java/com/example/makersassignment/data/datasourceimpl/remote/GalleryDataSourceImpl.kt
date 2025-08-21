package com.example.makersassignment.data.datasourceimpl.remote

import com.example.makersassignment.core.common.exception.ApiException
import com.example.makersassignment.data.datasource.remote.GalleryDataSource
import com.example.makersassignment.data.dto.remote.gallery.response.GalleryImageResponseDto
import com.example.makersassignment.data.service.GalleryService
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