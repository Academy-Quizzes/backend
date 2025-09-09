package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizResFull
import com.reactkotlin.quiz.backend.dto.QuizResWithoutAnswer
import com.reactkotlin.quiz.backend.entity.Quiz
import com.reactkotlin.quiz.backend.entity.toResFull
import com.reactkotlin.quiz.backend.entity.toResWithoutAnswer
import com.reactkotlin.quiz.backend.repository.QuizRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class QuizServiceImpl(private val quizRepository: QuizRepository): QuizService {

    override fun getAllQuizzes(): List<QuizResWithoutAnswer> {
        return quizRepository.findAll().map { it.toResWithoutAnswer() }
    }

    override fun getQuizById(id: Int): QuizResWithoutAnswer {
        return quizRepository.findById(id)?.toResWithoutAnswer()
            ?: throw IllegalArgumentException("Quiz with id=${id} not found")
    }

    @Transactional
    override fun addQuiz(quiz: QuizReq): QuizResFull {
        val newQuiz=Quiz.create(quiz.title, quiz.text, quiz.options, quiz.answer)

        return quizRepository.add(newQuiz).toResFull()
    }
    @Transactional
    override fun updateQuiz(quizId: Int, quiz: QuizReq): QuizResFull {

        quizRepository.findById(quizId)
            ?: throw IllegalArgumentException("Quiz with id=${quizId} not found")

        val quizEntity = Quiz(
            id = quizId,
            title = quiz.title,
            text = quiz.text,
            options = quiz.options,
            answer = quiz.answer
        )

        val updatedQuiz = quizRepository.update(quizEntity).toResFull()

        return updatedQuiz
    }

    @Transactional
    override fun deleteQuiz(id: Int) {

//        quizRepository.findById(id) ?: throw QuizNotFoundException(id)
        quizRepository.findById(id) ?: throw IllegalArgumentException("Quiz with id=${id} not found")

        quizRepository.deleteById(id)

    }
}