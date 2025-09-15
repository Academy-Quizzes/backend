package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.QuizRes
import com.reactkotlin.quiz.backend.service.QuizService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuizController(private val quizService: QuizService) {


    @GetMapping("/quizzes")
    fun getQuizzes(): List<QuizRes> {
        return quizService.getAll()
    }
}