package com.attilapalfi.mdschedule.mdschedulebackend.domain.model.error


enum class ErrorCode {
    NOT_SPECIALIST
}

data class Error(
    val errorCode: ErrorCode,
    val message: String
)
