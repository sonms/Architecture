package com.example.makersassignment.data.dto.local

import com.example.makersassignment.domain.entity.local.UserEntity

data class UserLocalDto(
    val id : String,
    val password: String
) {
    fun toDomain() = UserEntity.Impl(
        id = id,
        password = password
    )
}
