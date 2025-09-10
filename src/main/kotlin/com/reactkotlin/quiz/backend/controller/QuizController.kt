package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.service.QuizService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

}