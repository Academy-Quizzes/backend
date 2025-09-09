package com.reactkotlin.quiz.backend.dto

data class QuizResFull(
    val id:Int,
    val title: String,
    val text: String,
    val options: List<String>,
    val answer: List<Int>
)
