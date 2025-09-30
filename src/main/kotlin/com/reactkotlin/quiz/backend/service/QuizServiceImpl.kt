package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.dto.TopicRes
import com.reactkotlin.quiz.backend.entity.Quiz
import com.reactkotlin.quiz.backend.mapper.toQuestionRes
import com.reactkotlin.quiz.backend.repository.QuizRepository
import com.reactkotlin.quiz.backend.repository.QuestionRepository
import com.reactkotlin.quiz.backend.repository.TopicRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuizServiceImpl(
    private val quizRepository: QuizRepository,
    private val questionRepository: QuestionRepository,
    private val topicRepository: TopicRepository
) : QuizService {

    @Transactional
    override fun createQuiz(quizReq: QuizReq): QuizRes {
        val topic = quizReq.topicId?.let { topicRepository.findById(it).orElse(null) }
        val questions = questionRepository.findAllById(quizReq.questionIds)

        val quiz = Quiz(
            title = quizReq.title,
            description = quizReq.description,
            topic = topic,
            questions = questions.toMutableList()
        )

        return quizRepository.save(quiz).toQuizRes()
    }

    override fun getQuizById(quizId: Long): QuizRes {
        val quiz = quizRepository.findById(quizId)
            .orElseThrow { IllegalArgumentException("Quiz not found with id: $quizId") }
        return quiz.toQuizRes()
    }

    override fun getAllQuizzes(): List<QuizRes> {
        return quizRepository.findAll().map { it.toQuizRes() }
    }

    @Transactional
    override fun addQuestionsToQuiz(quizId: Long, questionIds: List<Long>): QuizRes {
        val quiz = quizRepository.findById(quizId)
            .orElseThrow { IllegalArgumentException("Quiz not found with id: $quizId") }

        val questions = questionRepository.findAllById(questionIds)

        quiz.questions.addAll(questions)

        return quizRepository.save(quiz).toQuizRes()
    }

    @Transactional
    override fun updateQuiz(quizId: Long, quizReq: QuizReq): QuizRes {
        val existingQuiz = quizRepository.findById(quizId)
            .orElseThrow { IllegalArgumentException("Quiz not found with id: $quizId") }
        val topic = quizReq.topicId?.let { topicRepository.findById(it).orElse(null) }
        val questions = questionRepository.findAllById(quizReq.questionIds)

        existingQuiz.title = quizReq.title
        existingQuiz.description = quizReq.description
        existingQuiz.topic = topic
        existingQuiz.questions = questions.toMutableList()

        return quizRepository.save(existingQuiz).toQuizRes()
    }

    @Transactional
    override fun deleteQuizById(quizId: Long) {
        if (!quizRepository.existsById(quizId)) {
            throw IllegalArgumentException("Quiz not found with id: $quizId")
        }
        quizRepository.deleteById(quizId)
    }

    private fun Quiz.toQuizRes(): QuizRes {
        return QuizRes(
            id = this.id!!,
            title = this.title,
            description = this.description,
            createdAt = this.createdAt.toString(),
            topic = this.topic?.let { TopicRes(it.id!!, it.name) },
            questions = this.questions.map { it.toQuestionRes() }
        )
    }
}
