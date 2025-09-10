package com.reactkotlin.quiz.backend.dto

data class QuizRes(
    val id:Int,
    val title: String,
    val text: String,
    val options: List<String>,
)
