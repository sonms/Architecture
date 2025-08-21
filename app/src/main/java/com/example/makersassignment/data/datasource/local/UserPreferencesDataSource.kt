package com.example.makersassignment.data.datasource.local

import com.example.makersassignment.data.dto.local.UserLocalDto
import kotlinx.coroutines.flow.Flow

interface UserPreferencesDataSource {
    suspend fun saveUserInfo(id: String, password: String)
    fun getUserInfo(): Flow<UserLocalDto>
}