package com.example.makersassignment.presentation.auth.model

import androidx.compose.runtime.Immutable
import com.example.makersassignment.domain.local.entity.UserEntity

@Immutable
internal data class UserInfoUiModel(
    val userInfo : UserEntity = UserEntity.EMPTY
): UserEntity by userInfo {
    fun modify(
        id: String = this.id,
        password: String = this.password
    ): UserInfoUiModel {
        return UserInfoUiModel(
            UserEntity.Impl(id = id, password = password)
        )
    }
}
