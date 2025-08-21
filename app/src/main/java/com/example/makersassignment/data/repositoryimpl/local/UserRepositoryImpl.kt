package com.example.makersassignment.data.repositoryimpl.local

import com.example.makersassignment.data.datasource.local.UserPreferencesDataSource
import com.example.makersassignment.domain.entity.local.UserEntity
import com.example.makersassignment.domain.repository.local.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource
) : UserRepository {
    override suspend fun saveUserInfo(userEntity: UserEntity) {
        userPreferencesDataSource.saveUserInfo(
            id = userEntity.id,
            password = userEntity.password
        )
    }

    override fun getUserInfo(): Flow<UserEntity> {
        return userPreferencesDataSource.getUserInfo().map { userLocalDto ->
            userLocalDto.toDomain()
        }
    }
}