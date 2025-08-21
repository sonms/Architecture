package com.example.makersassignment.data.service

import com.example.makersassignment.data.dto.remote.gallery.response.GalleryImageResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GalleryService {
    @GET("v2/list")
    suspend fun getImages(
        @Query("page") page : Int,
        @Query("limit") limit : Int
    ) : Response<List<GalleryImageResponseDto>>
}