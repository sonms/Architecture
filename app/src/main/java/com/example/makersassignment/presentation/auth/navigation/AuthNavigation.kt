package com.example.makersassignment.presentation.auth.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.makersassignment.core.navigation.MainTabRoute
import com.example.makersassignment.core.navigation.Route
import com.example.makersassignment.presentation.auth.SignInRoute
import kotlinx.serialization.Serializable

fun NavGraphBuilder.authGraph(
    navigateUp: () -> Unit,
    navigateHome: () -> Unit,
) {
    composable<Auth> {
        SignInRoute(
            navigateHome = navigateHome
        )
    }
}

@Serializable
data object Auth : Route