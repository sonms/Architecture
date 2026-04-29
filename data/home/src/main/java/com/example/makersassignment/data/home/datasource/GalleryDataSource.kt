package com.example.makersassignment.data.home.datasource

import com.example.makersassignment.data.home.dto.response.GalleryImageResponseDto

interface GalleryDataSource {
    suspend fun getImages(page: Int, limit: Int): List<GalleryImageResponseDto>
}
