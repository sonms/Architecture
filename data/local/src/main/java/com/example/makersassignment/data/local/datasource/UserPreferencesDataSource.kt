package com.example.makersassignment.data.local.datasource

import com.example.makersassignment.data.local.dto.UserLocalDto
import kotlinx.coroutines.flow.Flow

interface UserPreferencesDataSource {
    suspend fun saveUserInfo(id: String, password: String)
    fun getUserInfo(): Flow<UserLocalDto>
}
