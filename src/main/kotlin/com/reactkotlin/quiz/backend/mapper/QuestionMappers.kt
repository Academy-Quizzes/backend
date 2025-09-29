package com.reactkotlin.quiz.backend.mapper

import com.reactkotlin.quiz.backend.dto.QuestionRes
import com.reactkotlin.quiz.backend.dto.QuestionResFull
import com.reactkotlin.quiz.backend.entity.Question

fun Question.toQuestionRes(): QuestionRes = QuestionRes(
    id!!,
    title,
    text,
    options,
    topics.map { it.name },
    creatorId!!
)

fun Question.toQuestionFullRes(): QuestionResFull = QuestionResFull(
    id!!,
    title,
    text,
    options,
    answers,
    topics.map { it.name },
    creatorId!!
)