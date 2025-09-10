package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes

interface QuizService {
    fun getAllQuizzes(): List<QuizRes>

    fun getQuizById(id: Int): QuizRes

    fun addQuiz(quiz: QuizReq)

    fun updateQuiz(quizId: Int, quiz: QuizReq): QuizRes

    fun deleteQuiz(id: Int)
}