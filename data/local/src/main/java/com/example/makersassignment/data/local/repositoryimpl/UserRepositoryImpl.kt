package com.example.makersassignment.data.local.repositoryimpl

import com.example.makersassignment.domain.local.entity.UserEntity
import com.example.makersassignment.domain.local.repository.UserRepository
import com.example.makersassignment.data.local.datasource.UserPreferencesDataSource
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
