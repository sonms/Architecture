package com.example.makersassignment.data.datasource

import com.example.makersassignment.data.service.GalleryService
import javax.inject.Inject

class GalleryDataSource @Inject constructor(
    private val service: GalleryService
) {
    suspend fun getImages(page : Int, limit : Int) = service.getImages(page, limit)
}