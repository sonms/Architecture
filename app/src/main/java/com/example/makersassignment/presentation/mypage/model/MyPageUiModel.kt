package com.example.makersassignment.presentation.mypage.model

import androidx.compose.runtime.Immutable
import com.example.makersassignment.domain.entity.local.UserEntity

@Immutable
data class MyPageUiModel(
    val userInfo : UserEntity = UserEntity.EMPTY
): UserEntity by userInfo
