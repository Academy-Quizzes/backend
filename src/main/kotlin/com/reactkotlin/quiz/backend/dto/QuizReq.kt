package com.reactkotlin.quiz.backend.dto

import jakarta.validation.constraints.NotEmpty

data class QuizReq(
    @field:NotEmpty(message = "Title cannot be empty")
    val title: String,
    @field:NotEmpty(message = "Description cannot be empty")
    val description: String,
    val topicId: Long?,
    val questionIds: List<Long> = listOf()
)
