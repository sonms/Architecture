package com.example.makersassignment.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makersassignment.domain.usecase.local.SaveUserInfoUseCase
import com.example.makersassignment.presentation.auth.model.toEntity
import dagger.hilt.android.lifecycle.HiltViewModel
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
class SignInViewModel @Inject constructor(
    private val saveUserInfoUseCase: SaveUserInfoUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignInState())
    val uiState : StateFlow<SignInState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SignInSideEffect>()
    val sideEffect : SharedFlow<SignInSideEffect> = _sideEffect.asSharedFlow()


    fun onIdChange(id : String) {
        _uiState.update { state ->
            val isError = id.isNotEmpty() && (id.length !in 6..10)

            state.copy(
                userInfo = state.userInfo.copy(id = id),
                isIdError = isError
            )
        }
    }

    fun onPasswordChange(password : String) {
        _uiState.update { state ->
            val isError = password.isNotEmpty() && (password.length !in 8..12)

            state.copy(
                userInfo = state.userInfo.copy(password = password),
                isPasswordError = isError
            )
        }
    }

    fun onSignInClick() {
        if (!_uiState.value.isIdError && !_uiState.value.isPasswordError) {
            _uiState.update {
                it.copy(
                    isSignInSucceed = true
                )
            }

            viewModelScope.launch {
                val userInfo = _uiState.value.userInfo

                _sideEffect.emit(SignInSideEffect.SignInSucceed)

                saveUserInfoUseCase(
                    userEntity = userInfo.toEntity()
                )
            }
        } else {
            _uiState.update {
                it.copy(isSignInSucceed = false)
            }

            viewModelScope.launch {
                _sideEffect.emit(SignInSideEffect.SignInFailed)
            }
        }
    }
}