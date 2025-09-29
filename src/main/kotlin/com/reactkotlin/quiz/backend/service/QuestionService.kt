package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuestionAnswerRes
import com.reactkotlin.quiz.backend.dto.QuestionReq
import com.reactkotlin.quiz.backend.dto.QuestionRes
import com.reactkotlin.quiz.backend.dto.QuestionResFull

interface QuestionService {

    fun getAll(): List<QuestionRes>

    fun getById(id: Long): QuestionRes

    fun add(question: QuestionReq): QuestionResFull

    fun update(questionId: Long, question: QuestionReq)

    fun delete(id: Long)

    fun solve(id: Long, userAnswers: List<Int>): QuestionAnswerRes

}