package com.example.makersassignment.presentation.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SignInRoute(
    navigateHome: () -> Unit,
) {
    SignInScreen(
        navigateHome = navigateHome
    )
}

@Composable
fun SignInScreen(
    navigateHome: () -> Unit,
) {
    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = navigateHome
        ) {
            Text(
                text = "로그인"
            )
        }
    }
}