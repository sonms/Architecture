package com.example.makersassignment.domain.local.entity

interface UserEntity {
    val id: String
    val password: String

    data class Impl(
        override val id: String,
        override val password: String
    ) : UserEntity

    companion object {
        val EMPTY = Impl(id = "", password = "")
    }
}
