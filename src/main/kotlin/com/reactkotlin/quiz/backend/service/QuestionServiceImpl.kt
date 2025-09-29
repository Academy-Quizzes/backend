package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.QuestionAnswerRes
import com.reactkotlin.quiz.backend.dto.QuestionReq
import com.reactkotlin.quiz.backend.dto.QuestionRes
import com.reactkotlin.quiz.backend.mapper.toQuestionFullRes
import com.reactkotlin.quiz.backend.mapper.toQuestionRes
import com.reactkotlin.quiz.backend.dto.QuestionResFull
import com.reactkotlin.quiz.backend.entity.Question
import com.reactkotlin.quiz.backend.exception.QuestionNotFoundException
import com.reactkotlin.quiz.backend.repository.QuestionRepository
import com.reactkotlin.quiz.backend.repository.TopicRepository
import com.reactkotlin.quiz.backend.repository.UserRepository
import com.reactkotlin.quiz.backend.security.UserDetailsImpl
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class QuestionServiceImpl(
    private val questionRepository: QuestionRepository,
    private val topicRepository: TopicRepository,
    private val userRepository: UserRepository
) : QuestionService {

    companion object {
        const val QUESTION_CORRECT_MESSAGE = "Congratulations, you're right!"
        const val QUESTION_WRONG_MESSAGE = "Wrong answer! Please, try again."
    }

    override fun getAll(): List<QuestionRes> =
        questionRepository.findAll().map { it.toQuestionRes() }

    override fun getById(id: Long): QuestionRes =
        questionRepository.findById(id)
            .map { it.toQuestionRes() }
            .orElseThrow { QuestionNotFoundException(id) }

    @Transactional
    override fun add(question: QuestionReq): QuestionResFull {
        val topics = if (question.topicIds.isEmpty()) {
            mutableSetOf(topicRepository.findById(1L)
                .orElseThrow { IllegalStateException("default topic not found in DB for some reason") })
        } else {
            topicRepository.findAllById(question.topicIds).toMutableSet()
        }

        val authentication = SecurityContextHolder.getContext().authentication

        // this check as of now doesnt even get triggered
        // because if not authenticated SPring Security
        // will catch it and return 401 not authorized
        // will leave this here till in future we add a
        // custom additional filter for checking specific
        // exceptions
        if (authentication == null || !authentication.isAuthenticated || authentication.principal == "anonymousUser") {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "User must be authenticated to create a question")
        }

        val userDetails = authentication.principal as? UserDetailsImpl
            ?: throw IllegalArgumentException("Invalid user details in authentication context")

        val creatorId = userDetails.getId()
            ?: throw IllegalArgumentException("User ID not found in authentication details")

        val newQuestion = Question(
            title = question.title,
            text = question.text,
            options = question.options,
            answers = question.answers,
            topics = topics,
            creatorId = creatorId
        )
        return questionRepository.save(newQuestion).toQuestionFullRes()
    }

    @Transactional
    override fun update(questionId: Long, question: QuestionReq) {
        val existingQuestion = questionRepository.findById(questionId)
            .orElseThrow { QuestionNotFoundException(questionId) }

        val topics = topicRepository.findAllById(question.topicIds).toMutableSet()

        existingQuestion.title = question.title
        existingQuestion.text = question.text
        existingQuestion.options = question.options
        existingQuestion.answers = question.answers
        existingQuestion.topics = topics

        questionRepository.save(existingQuestion)
    }

    @Transactional
    override fun delete(id: Long) {
        if (!questionRepository.existsById(id)) {
            QuestionNotFoundException(id)
        }
        questionRepository.deleteById(id)
    }
    override fun solve(
        id: Long,
        userAnswers: List<Int>
    ): QuestionAnswerRes {
        val question = questionRepository.findById(id)
            .orElseThrow { QuestionNotFoundException(id) }

        val isCorrect = isQuestionSolved(question, userAnswers)

        return if (isCorrect) {
            QuestionAnswerRes(true, QUESTION_CORRECT_MESSAGE)
        } else {
            QuestionAnswerRes(false, QUESTION_WRONG_MESSAGE)
        }

    }


    private fun isQuestionSolved(question: Question, userAnswers: List<Int>): Boolean {

        return userAnswers.sorted() == question.answers.sorted()
    }

}