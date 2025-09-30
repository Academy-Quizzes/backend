package com.reactkotlin.quiz.backend.dto

data class QuizRes(
    val id: Long,
    val title: String,
    val description: String,
    val createdAt: String,
    val topic: TopicRes?,
    val questions: List<QuestionRes> = listOf()
)
