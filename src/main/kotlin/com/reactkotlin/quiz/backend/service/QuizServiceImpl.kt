package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizAnswerRes
import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.mapper.toQuizFullRes
import com.reactkotlin.quiz.backend.mapper.toQuizRes
import com.reactkotlin.quiz.backend.dto.QuizResFull
import com.reactkotlin.quiz.backend.entity.Quiz
import com.reactkotlin.quiz.backend.exception.QuizNotFoundException
import com.reactkotlin.quiz.backend.repository.QuizRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class QuizServiceImpl(private val quizRepository: QuizRepository) : QuizService {

    companion object {
        const val QUIZ_CORRECT_MESSAGE = "Congratulations, you're right!"
        const val QUIZ_WRONG_MESSAGE = "Wrong answer! Please, try again."
    }

    override fun getAll(): List<QuizRes> =
        quizRepository.findAll().map { it.toQuizRes() }

    override fun getById(id: Long): QuizRes =
        quizRepository.findById(id)
            .map { it.toQuizRes() }
            .orElseThrow { QuizNotFoundException(id) }

    @Transactional
    override fun add(quiz: QuizReq): QuizResFull {
        val newQuiz = Quiz(
            title = quiz.title,
            text = quiz.text,
            options = quiz.options,
            answers = quiz.answers
        )
        return quizRepository.save(newQuiz).toQuizFullRes()
    }

    @Transactional
    override fun update(quizId: Long, quiz: QuizReq) {
        val existingQuiz = quizRepository.findById(quizId)
            .orElseThrow { QuizNotFoundException(quizId) }

        existingQuiz.title = quiz.title
        existingQuiz.text = quiz.text
        existingQuiz.options = quiz.options
        existingQuiz.answers = quiz.answers

        quizRepository.save(existingQuiz)
    }

    @Transactional
    override fun delete(id: Long) {
        if (!quizRepository.existsById(id)) {
            QuizNotFoundException(id)
        }
        quizRepository.deleteById(id)
    }



    override fun solve(
        id: Long,
        userAnswers: List<Int>
    ): QuizAnswerRes {
        val quiz = quizRepository.findById(id)
            .orElseThrow { QuizNotFoundException(id) }

        val isCorrect = isQuizSolved(quiz, userAnswers)

        return if (isCorrect) {
            QuizAnswerRes(true, QUIZ_CORRECT_MESSAGE)
        } else {
            QuizAnswerRes(false, QUIZ_WRONG_MESSAGE)
        }

    }


    private fun isQuizSolved(quiz: Quiz, userAnswers: List<Int>): Boolean {

        return userAnswers.sorted() == quiz.answers.sorted()
    }

}