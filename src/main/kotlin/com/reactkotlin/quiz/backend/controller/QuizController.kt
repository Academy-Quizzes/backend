package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.service.QuizService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/quizzes")
class QuizController(
    private val quizService: QuizService
) {

    @PostMapping
    fun createQuiz(@RequestBody quizReq: QuizReq): ResponseEntity<QuizRes> {
        val createdQuiz = quizService.createQuiz(quizReq)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz)
    }

    @GetMapping("/{quizId}")
    fun getQuizById(@PathVariable quizId: Long): ResponseEntity<QuizRes> {
        val quiz = quizService.getQuizById(quizId)
        return ResponseEntity.ok(quiz)
    }

    @GetMapping
    fun getAllQuizzes(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "6") size: Int,
    ): ResponseEntity<Page<QuizRes>> {
        val quizPage = quizService.getAllQuizzes(page, size)
        return ResponseEntity.ok(quizPage)
    }

    @PostMapping("/{quizId}/questions")
    fun addQuestionsToQuiz(
        @PathVariable quizId: Long,
        @RequestBody questionIds: List<Long>
    ): ResponseEntity<QuizRes> {
        val updatedQuiz = quizService.addQuestionsToQuiz(quizId, questionIds)
        return ResponseEntity.ok(updatedQuiz)
    }

    @PutMapping("/{quizId}")
    fun updateQuiz(
        @PathVariable quizId: Long,
        @RequestBody quizReq: QuizReq
    ): ResponseEntity<QuizRes> {
        val updatedQuiz = quizService.updateQuiz(quizId, quizReq)
        return ResponseEntity.ok(updatedQuiz)
    }

    @DeleteMapping("/{quizId}")
    fun deleteQuizById(@PathVariable quizId: Long): ResponseEntity<Unit> {
        quizService.deleteQuizById(quizId)
        return ResponseEntity.noContent().build()
    }
}

