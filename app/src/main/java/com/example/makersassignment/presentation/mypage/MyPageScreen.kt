package com.example.makersassignment.presentation.mypage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.makersassignment.presentation.mypage.component.UserInfoCard

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val uiState by viewModel.userInfo.collectAsStateWithLifecycle()

    MyPageScreen(
        paddingValues = paddingValues,
        id = uiState.id,
        password = uiState.password
    )
}

@Composable
fun MyPageScreen(
    paddingValues: PaddingValues,
    id : String,
    password : String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        UserInfoCard(
            id = id,
            password = password
        )
    }
}