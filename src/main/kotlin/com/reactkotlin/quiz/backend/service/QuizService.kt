package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes

interface QuizService {
    fun createQuiz(quizReq: QuizReq): QuizRes
    fun getQuizById(quizId: Long): QuizRes
    fun getAllQuizzes(): List<QuizRes>
    fun addQuestionsToQuiz(quizId: Long, questionIds: List<Long>): QuizRes
    fun updateQuiz(quizId: Long, quizReq: QuizReq): QuizRes
    fun deleteQuizById(quizId: Long)
}

