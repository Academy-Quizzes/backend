package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizAnswerRes
import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.dto.QuizResFull

interface QuizService {

    fun getAll(): List<QuizRes>

    fun getById(id: Long): QuizRes

    fun add(quiz: QuizReq): QuizResFull

    fun update(quizId: Long, quiz: QuizReq)

    fun delete(id: Long)

    fun solve(id: Long, userAnswers: List<Int>): QuizAnswerRes

}