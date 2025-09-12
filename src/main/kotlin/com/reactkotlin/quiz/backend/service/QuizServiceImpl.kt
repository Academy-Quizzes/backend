package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizAnswerRes
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

    companion object {
        const val QUIZ_CORRECT_MESSAGE = "Congratulations, you're right!"
        const val QUIZ_WRONG_MESSAGE = "Wrong answer! Please, try again."
    }

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


    @Transactional
    override fun update(
        quizId: Int,
        quiz: QuizReq
    ){
        val getQuiz = quizRepository.findById(quizId)
            ?: throw IllegalArgumentException("Quiz with id=${quizId} not found")

        getQuiz.title = quiz.title
        getQuiz.text = quiz.text
        getQuiz.options = quiz.options
        getQuiz.answers = quiz.answers

      quizRepository.update(getQuiz)

    }



    @Transactional
    override fun delete(id: Int) {

        quizRepository.findById(id)
            ?: throw IllegalArgumentException("Quiz with id=${id} not found")

        quizRepository.deleteById(id)

    }



    override fun solve(

        id: Int,
        userAnswers: List<Int>
    ): QuizAnswerRes {
        val quiz = quizRepository.findById(id) ?: throw IllegalArgumentException("Quiz with id=${id} not found")

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