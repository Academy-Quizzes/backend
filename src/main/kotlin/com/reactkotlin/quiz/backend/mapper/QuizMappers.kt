package com.reactkotlin.quiz.backend.mapper

import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.dto.QuizResFull
import com.reactkotlin.quiz.backend.entity.Quiz

fun Quiz.toQuizRes(): QuizRes = QuizRes(id, title, text, options)

fun Quiz.toQuizFullRes(): QuizResFull = QuizResFull(id, title, text, options, answers)