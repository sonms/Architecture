package com.example.makersassignment.domain.home.repository

import com.example.makersassignment.domain.home.entity.GalleryImageEntity

interface GalleryRepository {
    suspend fun getGalleryImageList(page : Int, limit : Int) : Result<List<GalleryImageEntity>>
}
