package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.QuizAnswerReq
import com.reactkotlin.quiz.backend.dto.QuizAnswerRes
import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.dto.QuizResFull
import com.reactkotlin.quiz.backend.service.QuizService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuizController(private val quizService: QuizService) {


    @GetMapping("/quizzes")
    fun getQuizzes(): List<QuizRes> {
        return quizService.getAll()
    }


    @GetMapping("/quizzes/{quizId}")
    fun getQuiz(@PathVariable quizId: Int): ResponseEntity<QuizRes> {
        return try {
            ResponseEntity.ok(quizService.getById(quizId))
        } catch (e: IllegalArgumentException) {
            ResponseEntity.notFound().build()
        }
    }


    @PostMapping("/quizzes")
    fun addQuiz(@Valid @RequestBody quiz: QuizReq): ResponseEntity<QuizResFull> {
        val added = quizService.add(quiz)
        return try { ResponseEntity.status(HttpStatus.CREATED).body(added)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().build()
        }
    }


    @PostMapping("/quizzes/{quizId}/solve")
    fun solveQuiz(@PathVariable quizId: Int, @RequestBody quizAnswer: QuizAnswerReq): ResponseEntity<QuizAnswerRes> {

        val answer = quizService.solve(quizId, quizAnswer.answers)

        return ResponseEntity.status(HttpStatus.OK).body(answer)

    }

    @DeleteMapping("/quizzes/{quizId}")
    fun deleteQuiz(@PathVariable quizId: Int): ResponseEntity<Unit> {

        return try {

            quizService.delete(quizId)

            ResponseEntity.noContent().build()
        } catch (e: IllegalArgumentException) {
            ResponseEntity.notFound().build()
        }
    }


    @PutMapping("/quizzes/{id}")
    fun updateQuiz(@PathVariable id: Int,@Valid @RequestBody quiz: QuizReq): ResponseEntity<Unit> {

        return try {

            quizService.update(id, quiz)
            ResponseEntity.noContent().build()

        } catch (e: IllegalArgumentException) {
            ResponseEntity.notFound().build()
        }
    }

}