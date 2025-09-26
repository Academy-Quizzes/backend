package com.reactkotlin.quiz.backend.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class RegisterUserReq(
    @field: Email(message = "Invalid email format")
    @field: NotBlank(message = "Email must not be blank")
    val email: String,

    @field: Size(min = 8, message = "Password must be at least 8 characters long")
    @field: Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]*$",
        message = "Password must contain both letters and digits"
    )
    val password: String
)
