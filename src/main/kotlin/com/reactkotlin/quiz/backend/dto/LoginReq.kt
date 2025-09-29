package com.reactkotlin.quiz.backend.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginReq(
    @field:NotBlank
    @field:Email
    val email: String,
    @field:NotBlank
    val password: String
)
