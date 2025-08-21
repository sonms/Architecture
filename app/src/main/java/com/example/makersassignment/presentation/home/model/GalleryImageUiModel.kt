package com.example.makersassignment.presentation.home.model

import com.example.makersassignment.domain.entity.GalleryImageEntity

data class GalleryImageUiModel(
    val id : String,
    val author : String,
    val width : Int,
    val height : Int,
    val url : String,
    val downloadUrl : String
)

fun GalleryImageEntity.toUiModel() : GalleryImageUiModel {
    val targetSize = 300
    val baseUrl = downloadUrl.substringBeforeLast("/").substringBeforeLast("/")
    val finalUrl = "$baseUrl/$targetSize.jpg"

    return GalleryImageUiModel(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        downloadUrl = finalUrl
    )
}
