package com.reactkotlin.quiz.backend.dto

import com.reactkotlin.quiz.backend.validator.ValidQuizReq
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@ValidQuizReq
data class QuizReq(

    @field:NotBlank
    val title: String,
    @field:NotBlank
    val text: String,
    @field:Size(min = 2, max = 4)
    val options: List<String>,

    val answers: List<Int>

)
