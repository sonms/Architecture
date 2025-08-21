package com.example.makersassignment.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.makersassignment.domain.usecase.local.GetUserInfoUseCase
import com.example.makersassignment.presentation.mypage.model.MyPageUiModel
import com.example.makersassignment.presentation.mypage.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    getUserInfoUseCase: GetUserInfoUseCase,
) : ViewModel() {
    val userInfo: StateFlow<MyPageUiModel> = getUserInfoUseCase()
        .map { userEntity ->
            userEntity.toUiModel()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = MyPageUiModel()
        )
}