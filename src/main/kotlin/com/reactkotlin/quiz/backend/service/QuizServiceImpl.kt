package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.mapper.toQuizRes
import com.reactkotlin.quiz.backend.repository.QuizRepository
import org.springframework.stereotype.Service

@Service
class QuizServiceImpl(private val quizRepository: QuizRepository) : QuizService {

    override fun getAll(): List<QuizRes> {
        return quizRepository.findAll().map { it.toQuizRes() }
    }

    override fun getById(id: Int): QuizRes {
        TODO("Not yet implemented")
    }

    override fun add(quiz: QuizReq) {
        TODO("Not yet implemented")
    }

    override fun update(
        quizId: Int,
        quiz: QuizReq
    ): QuizRes {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}