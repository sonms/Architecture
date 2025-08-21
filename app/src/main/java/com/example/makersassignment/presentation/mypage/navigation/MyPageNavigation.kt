package com.example.makersassignment.presentation.mypage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.makersassignment.core.navigation.MainTabRoute
import com.example.makersassignment.presentation.mypage.MyPageRoute
import kotlinx.serialization.Serializable

fun NavController.navigateMyPage(
    navOptions: NavOptions?
) {
    navigate(MyPage, navOptions)
}

fun NavGraphBuilder.myPageGraph(
    paddingValues: PaddingValues,
) {
    composable<MyPage> {
        MyPageRoute(
            paddingValues = paddingValues,
        )
    }
}

@Serializable
data object MyPage : MainTabRoute