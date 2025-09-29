package com.reactkotlin.quiz.backend.mapper

import com.reactkotlin.quiz.backend.dto.QuestionRes
import com.reactkotlin.quiz.backend.dto.QuestionResFull
import com.reactkotlin.quiz.backend.entity.Question

fun Question.toQuestionRes(): QuestionRes = QuestionRes(
    id=id!!,
    title=title,
    text=text,
    options=options,
    topics=topics.map { it.name },
    creatorId=creatorId
)

fun Question.toQuestionFullRes(): QuestionResFull = QuestionResFull(
    id=id!!,
    title=title,
    text=text,
    options=options,
    answers=answers,
    topics=topics.map { it.name },
    creatorId=creatorId
)