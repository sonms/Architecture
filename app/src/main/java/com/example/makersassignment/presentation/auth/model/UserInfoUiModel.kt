package com.example.makersassignment.presentation.auth.model

import androidx.compose.runtime.Immutable
import com.example.makersassignment.domain.entity.local.UserEntity

@Immutable
data class UserInfoUiModel(
    val id : String = "",
    val password : String = ""
)

fun UserInfoUiModel.toEntity() : UserEntity {
    return UserEntity(
        id = id,
        password = password
    )
}