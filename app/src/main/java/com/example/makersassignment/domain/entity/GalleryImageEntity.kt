package com.example.makersassignment.domain.entity

interface GalleryImageEntity {
    val id : String
    val author : String
    val width : Int
    val height : Int
    val url : String
    val downloadUrl : String

    data class Impl(
        override val id : String,
        override val author : String,
        override val width : Int,
        override val height : Int,
        override val url : String,
        override val downloadUrl : String
    ) : GalleryImageEntity

    companion object {
        val EMPTY = Impl(
            id = "",
            author = "",
            width = 0,
            height = 0,
            url = "",
            downloadUrl = ""
        )
    }
}
