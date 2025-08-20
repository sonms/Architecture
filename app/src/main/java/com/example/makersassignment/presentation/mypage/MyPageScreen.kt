package com.example.makersassignment.presentation.mypage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    MyPageScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp
    )
}

@Composable
fun MyPageScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Text(
            text = "마이페이지"
        )
    }
}