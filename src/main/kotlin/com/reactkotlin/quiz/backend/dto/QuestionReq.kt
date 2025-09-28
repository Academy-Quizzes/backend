package com.reactkotlin.quiz.backend.dto

import com.reactkotlin.quiz.backend.validator.ValidQuestionReq
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@ValidQuestionReq
data class QuestionReq(

    @field:NotBlank
    val title: String,
    @field:NotBlank
    val text: String,
    @field:Size(min = 2, max = 4)
    val options: List<String>,
    @field:Size(min = 1)
    val answers: List<Int>,
    @field:Size(min = 1)
    val topicIds: List<Long>

)
