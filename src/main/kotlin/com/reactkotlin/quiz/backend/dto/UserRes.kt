package com.reactkotlin.quiz.backend.dto

import com.reactkotlin.quiz.backend.entity.Role

data class UserRes(
    val id: Long?,
    val email: String,
    val role: Role
)
