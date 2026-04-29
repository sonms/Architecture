package com.example.makersassignment.data.local.dto

import com.example.makersassignment.domain.local.entity.UserEntity

data class UserLocalDto(
    val id : String,
    val password: String
) {
    fun toDomain() = UserEntity.Impl(
        id = id,
        password = password
    )
}
