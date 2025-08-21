package com.example.makersassignment.presentation.auth

import androidx.compose.runtime.Immutable

@Immutable
data class SignInState(
    val id : String = "",
    val password : String = "",
    val isSignInSucceed : Boolean = false,
    val isIdError : Boolean = false,
    val isPasswordError : Boolean = false
)

sealed interface SignInSideEffect {
    data object SignInSucceed : SignInSideEffect
    data object SignInFailed : SignInSideEffect
}
