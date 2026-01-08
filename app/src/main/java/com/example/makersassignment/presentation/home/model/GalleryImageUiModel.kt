package com.example.makersassignment.presentation.home.model

import androidx.compose.runtime.Immutable
import com.example.makersassignment.domain.entity.GalleryImageEntity

@Immutable
data class GalleryImageUiModel(
    val galleryImageUiModel : GalleryImageEntity = GalleryImageEntity.EMPTY
) : GalleryImageEntity by galleryImageUiModel
