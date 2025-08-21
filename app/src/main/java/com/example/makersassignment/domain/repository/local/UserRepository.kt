package com.example.makersassignment.domain.repository.local

import com.example.makersassignment.domain.entity.local.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun saveUserInfo(userEntity: UserEntity)
    fun getUserInfo(): Flow<UserEntity>
}