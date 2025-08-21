package com.example.makersassignment.data.datasource.remote

import com.example.makersassignment.data.dto.remote.gallery.response.GalleryImageResponseDto

interface GalleryDataSource {
    suspend fun getImages(page: Int, limit: Int): List<GalleryImageResponseDto>
}