package com.example.makersassignment.domain.repository

import com.example.makersassignment.domain.entity.GalleryImageEntity

interface GalleryRepository {
    suspend fun getGalleryImageList(page : Int, limit : Int) : Result<List<GalleryImageEntity>>
}