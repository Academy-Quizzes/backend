package com.reactkotlin.quiz.backend.mapper

import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.entity.Quiz

fun Quiz.toQuizRes(): QuizRes = QuizRes(id, title, text, options)