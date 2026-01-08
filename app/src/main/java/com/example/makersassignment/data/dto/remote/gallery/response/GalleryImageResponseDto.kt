package com.example.makersassignment.data.dto.remote.gallery.response

import com.example.makersassignment.domain.entity.GalleryImageEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GalleryImageResponseDto(
    @SerialName("id")
    val id : String,
    @SerialName("author")
    val author : String,
    @SerialName("width")
    val width : Int,
    @SerialName("height")
    val height : Int,
    @SerialName("url")
    val url : String,
    @SerialName("download_url")
    val downloadUrl : String
) {
    fun toDomain() = GalleryImageEntity.Impl(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        downloadUrl = downloadUrl
    )
}
