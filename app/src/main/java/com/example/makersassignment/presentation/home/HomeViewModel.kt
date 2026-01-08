package com.example.makersassignment.presentation.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.makersassignment.core.common.util.UiState
import com.example.makersassignment.domain.usecase.GetGalleryImageListUseCase
import com.example.makersassignment.presentation.home.model.GalleryImageUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGalleryImageListUseCase: GetGalleryImageListUseCase,
    private val imageLoader: ImageLoader,
    private val application: Application
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState : StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<HomeSideEffect>()
    val sideEffect : SharedFlow<HomeSideEffect> = _sideEffect.asSharedFlow()

    init {
        getInitGalleryImageList(_uiState.value.currentPage, 30)
    }

    fun getInitGalleryImageList(page : Int, limit : Int) {
        _uiState.update {
            it.copy(
                galleryImageList = UiState.Loading
            )
        }

        viewModelScope.launch {
            getGalleryImageListUseCase(page, limit)
                .onSuccess { data ->
                    _uiState.update { state ->
                        state.copy(
                            galleryImageList = UiState.Success(
                                data.map { GalleryImageUiModel(galleryImageUiModel = it) }.toPersistentList()
                            ),
                            isLoadingMore = false
                        )
                    }
                    prefetchImagesForPage(2)
                }
                .onFailure { failure ->
                    _uiState.update {
                        it.copy(
                            galleryImageList = UiState.Failure(failure.message ?: ""),
                            isLoadingMore = false
                        )
                    }
                }
        }
    }

    fun loadNextGalleryImage() {
        val currentState = _uiState.value.galleryImageList
        val nextPage = _uiState.value.currentPage + 1

        if (currentState is UiState.Success && !_uiState.value.isLoadingMore) {
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        isLoadingMore = true
                    )
                }

                getGalleryImageListUseCase(nextPage, 30)
                    .onSuccess { data ->
                        _uiState.update { state ->
                            state.copy(
                                galleryImageList = UiState.Success(
                                    data = currentState.data.addAll(data.map { GalleryImageUiModel(galleryImageUiModel = it) })
                                ),
                                isLoadingMore = false,
                                currentPage = nextPage
                            )
                        }

                        prefetchImagesForPage(nextPage + 1)
                    }
                    .onFailure { failure ->
                        _uiState.update {
                            it.copy(
                                isLoadingMore = false
                            )
                        }
                    }
            }
        }
    }

    // 미리 다음거 준비 pre-fetching
    private fun prefetchImagesForPage(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getGalleryImageListUseCase(page, 30)
                .onSuccess { imageEntityList ->
                    imageEntityList.forEach { entity ->
                        val targetSize = 300
                        val baseUrl = entity.downloadUrl.substringBeforeLast("/").substringBeforeLast("/")
                        val prefetchUrl = "$baseUrl/$targetSize.jpg"
                        val request = ImageRequest.Builder(application)
                            .size(targetSize)
                            .data(prefetchUrl)
                            .build()
                        imageLoader.enqueue(request)
                    }
                }
        }
    }
}
