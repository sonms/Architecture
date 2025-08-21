package com.example.makersassignment.domain.usecase.local

import com.example.makersassignment.domain.entity.local.UserEntity
import com.example.makersassignment.domain.repository.local.UserRepository
import javax.inject.Inject

class SaveUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity) {
        userRepository.saveUserInfo(userEntity)
    }
}