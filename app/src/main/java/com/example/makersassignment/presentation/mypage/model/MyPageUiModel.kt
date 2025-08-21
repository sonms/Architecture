package com.example.makersassignment.presentation.mypage.model

import androidx.compose.runtime.Immutable
import com.example.makersassignment.domain.entity.local.UserEntity

@Immutable
data class MyPageUiModel(
    val id : String = "",
    val password : String = ""
)

fun UserEntity.toUiModel(): MyPageUiModel {
    return MyPageUiModel(
        id = id,
        password = password
    )
}