package com.example.makersassignment.domain.local.usecase

import com.example.makersassignment.domain.local.entity.UserEntity
import com.example.makersassignment.domain.local.repository.UserRepository
import javax.inject.Inject

class SaveUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userEntity: UserEntity) {
        userRepository.saveUserInfo(userEntity)
    }
}
