package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.mapper.toQuizFullRes
import com.reactkotlin.quiz.backend.mapper.toQuizRes
import com.reactkotlin.quiz.backend.dto.QuizResFull
import com.reactkotlin.quiz.backend.entity.Quiz
import com.reactkotlin.quiz.backend.repository.QuizRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class QuizServiceImpl(private val quizRepository: QuizRepository) : QuizService {


    override fun getAll(): List<QuizRes> {
        return quizRepository.findAll().map { it.toQuizRes() }
    }


    override fun getById(id: Int): QuizRes {
        return quizRepository.findById(id)?.toQuizRes()
            ?: throw IllegalArgumentException("Quiz with id=${id} not found")

    }

    @Transactional
    override fun add(quiz: QuizReq): QuizResFull {

        val newQuiz = Quiz.create(
            quiz.title,
            quiz.text,
            quiz.options,
            quiz.answers
        )

        return quizRepository.add(newQuiz).toQuizFullRes()

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