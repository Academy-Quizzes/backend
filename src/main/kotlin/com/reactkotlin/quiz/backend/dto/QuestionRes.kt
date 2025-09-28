package com.reactkotlin.quiz.backend.dto

data class QuestionRes(
    val id: Long,
    val title: String,
    val text: String,
    val options: List<String>,
)
