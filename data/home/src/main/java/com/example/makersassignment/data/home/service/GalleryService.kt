package com.example.makersassignment.data.home.service

import com.example.makersassignment.data.home.dto.response.GalleryImageResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GalleryService {
    @GET("v2/list")
    suspend fun getImages(
        @Query("page") page : Int,
        @Query("limit") limit : Int
    ) : Response<List<GalleryImageResponseDto>>
}
