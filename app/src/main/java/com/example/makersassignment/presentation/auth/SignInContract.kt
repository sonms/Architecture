package com.example.makersassignment.presentation.auth

import androidx.compose.runtime.Immutable
import com.example.makersassignment.presentation.auth.model.UserInfoUiModel

@Immutable
data class SignInState(
    val userInfo : UserInfoUiModel = UserInfoUiModel(),
    val isSignInSucceed : Boolean = false,
    val isIdError : Boolean = false,
    val isPasswordError : Boolean = false
)

sealed interface SignInSideEffect {
    data object SignInSucceed : SignInSideEffect
    data object SignInFailed : SignInSideEffect
}
