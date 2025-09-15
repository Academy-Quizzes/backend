package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizAnswerRes
import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.dto.QuizResFull

interface QuizService {

    fun getAll(): List<QuizRes>

    fun getById(id: Int): QuizRes

    fun add(quiz: QuizReq): QuizResFull

    fun update(quizId: Int, quiz: QuizReq): QuizRes

    fun delete(id: Int)

    fun solve(id: Int, userAnswers: List<Int>): QuizAnswerRes

}