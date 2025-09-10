package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.entity.toRes
import com.reactkotlin.quiz.backend.repository.QuizRepository
import org.springframework.stereotype.Service

@Service
class QuizServiceImpl(private val quizRepository: QuizRepository) : QuizService {

    override fun getAllQuizzes(): List<QuizRes> {
        return quizRepository.findAll().map { it.toRes() }
    }

    override fun getQuizById(id: Int): QuizRes {
        TODO("Not yet implemented")
    }

    override fun addQuiz(quiz: QuizReq) {
        TODO("Not yet implemented")
    }

    override fun updateQuiz(
        quizId: Int,
        quiz: QuizReq
    ): QuizRes {
        TODO("Not yet implemented")
    }

    override fun deleteQuiz(id: Int) {
        TODO("Not yet implemented")
    }
}