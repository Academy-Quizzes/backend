package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.QuizResWithoutAnswer
import com.reactkotlin.quiz.backend.service.QuizService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuizController(private val quizService: QuizService) {

    @GetMapping("/")
    fun init():String{
        return "Web quiz starter"
    }

    @GetMapping("/quizzes")
    fun getQuizzes(): List<QuizResWithoutAnswer> {
        return quizService.getAllQuizzes()
    }

    @GetMapping("/quizzes/{quizId}")
    fun getQuiz(@PathVariable quizId: Int): QuizResWithoutAnswer {
        return quizService.getQuizById(quizId)
    }

}