package com.example.makersassignment.domain.local.repository

import com.example.makersassignment.domain.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun saveUserInfo(userEntity: UserEntity)
    fun getUserInfo(): Flow<UserEntity>
}
