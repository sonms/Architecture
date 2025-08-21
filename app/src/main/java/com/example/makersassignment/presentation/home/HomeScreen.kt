package com.example.makersassignment.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.example.makersassignment.R
import com.example.makersassignment.core.common.util.UiState
import com.example.makersassignment.core.designsystem.component.CommonLoadingIndicator
import com.example.makersassignment.presentation.home.component.GalleryImageItem
import com.example.makersassignment.presentation.home.model.GalleryImageUiModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lazyGridState = rememberLazyGridState()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    val toastMessage = remember {
        Toast.makeText(context, "로딩에 실패 했습니다 다시 시도해주세요", Toast.LENGTH_SHORT)
    }

    LaunchedEffect(lazyGridState, uiState) {
        val imageState = uiState.galleryImageList
        if (imageState is UiState.Success) {
            snapshotFlow { lazyGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
                .collect { lastVisibleItemIndex ->
                    if (lastVisibleItemIndex != null &&
                        lastVisibleItemIndex >= imageState.data.size - 20 &&
                        !uiState.isLoadingMore
                    ) {
                        viewModel.loadNextGalleryImage()
                    }
                }
        }
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is HomeSideEffect.HomeErrorMessage -> {
                        toastMessage.show()
                    }
                }
            }
    }

    when (val state = uiState.galleryImageList) {
        is UiState.Loading -> {
            CommonLoadingIndicator(
                modifier = Modifier
                    .padding(paddingValues)
            )
        }

        is UiState.Success -> {
            HomeScreen(
                paddingValues = paddingValues,
                imageList = state.data.toPersistentList(),
                isLoading = uiState.isLoadingMore,
                lazyGridState = lazyGridState,
            )
        }

        is UiState.Failure -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.msg
                )
            }
        }

        else -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.empty_message)
                )
            }
        }
    }
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    lazyGridState: LazyGridState,
    imageList : PersistentList<GalleryImageUiModel>,
    isLoading : Boolean = false,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            state = lazyGridState
        ) {
            items(imageList.size) { index ->
                GalleryImageItem(
                    imageUrl = imageList[index].downloadUrl,
                    author = imageList[index].author
                )
            }

            if (isLoading) {
                item(
                    span = {
                        GridItemSpan(maxLineSpan)
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}