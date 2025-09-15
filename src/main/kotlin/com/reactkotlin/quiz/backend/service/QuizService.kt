package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes

interface QuizService {
    fun getAll(): List<QuizRes>

    fun getById(id: Int): QuizRes

    fun add(quiz: QuizReq)

    fun update(quizId: Int, quiz: QuizReq): QuizRes

    fun delete(id: Int)
}