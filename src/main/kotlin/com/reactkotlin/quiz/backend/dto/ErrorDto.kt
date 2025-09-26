package com.reactkotlin.quiz.backend.dto

import java.time.LocalDateTime

data class ErrorDto(
    val status: Int,
    val error: String,
    val message: String,
    val path: String?,
    val timestamp: LocalDateTime = LocalDateTime.now()
)