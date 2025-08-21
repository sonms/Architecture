package com.example.makersassignment.core.common.exception

sealed class ApiException(message: String) : Exception(message) {
    data class HttpError(val code: Int, override val message: String) : ApiException(message)
    data class UnexpectedError(override val message: String) : ApiException(message)
}