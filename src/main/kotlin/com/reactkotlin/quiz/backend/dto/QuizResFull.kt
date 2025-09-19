package com.reactkotlin.quiz.backend.dto

data class QuizResFull(
    val id: Long,
    val title: String,
    val text: String,
    val options: List<String>,
    val answers: List<Int>
)
