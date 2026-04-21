package com.example.makersassignment.domain.local.usecase

import com.example.makersassignment.domain.local.repository.UserRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getUserInfo()
}
