package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import org.springframework.data.domain.Page

interface QuizService {
    fun createQuiz(quizReq: QuizReq): QuizRes
    fun getQuizById(quizId: Long): QuizRes
    fun addQuestionsToQuiz(quizId: Long, questionIds: List<Long>): QuizRes
    fun updateQuiz(quizId: Long, quizReq: QuizReq): QuizRes
    fun deleteQuizById(quizId: Long)
    fun getAllQuizzes(page: Int, size: Int): Page<QuizRes>
}

