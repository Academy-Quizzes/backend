package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizAnswerRes
import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizResFull
import com.reactkotlin.quiz.backend.dto.QuizResWithoutAnswer


interface QuizService {

    fun getAllQuizzes(): List<QuizResWithoutAnswer>

    fun getQuizById(id: Int): QuizResWithoutAnswer

    fun addQuiz(quiz: QuizReq): QuizResFull

    fun updateQuiz(quizId:Int ,quiz: QuizReq): QuizResFull

    fun deleteQuiz(id: Int)

}