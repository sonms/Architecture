package com.example.makersassignment.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.makersassignment.core.navigation.MainTabRoute
import com.example.makersassignment.presentation.home.HomeRoute
import kotlinx.serialization.Serializable

fun NavController.navigateHome(
    navOptions: NavOptions?
) {
    navigate(Home, navOptions)
}

fun NavGraphBuilder.homeGraph(
    paddingValues: PaddingValues,
) {
    composable<Home> {
        HomeRoute(
            paddingValues = paddingValues,
        )
    }
}

@Serializable
data object Home : MainTabRoute