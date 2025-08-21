package com.example.makersassignment.domain.usecase.local

import com.example.makersassignment.domain.repository.local.UserRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getUserInfo()
}