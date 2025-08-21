package com.example.makersassignment.presentation.home

import androidx.compose.runtime.Immutable
import com.example.makersassignment.core.common.util.UiState
import com.example.makersassignment.presentation.home.model.GalleryImageUiModel
import kotlinx.collections.immutable.PersistentList

@Immutable
data class HomeUiState(
    val galleryImageList : UiState<PersistentList<GalleryImageUiModel>> = UiState.Empty,
    val isLoadingMore : Boolean = false,
    val currentPage : Int = 1
)

sealed interface HomeSideEffect {
    data class HomeErrorMessage(val msg : String) : HomeSideEffect
}