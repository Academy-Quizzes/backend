package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.entity.Quiz
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuizController {

    @GetMapping("/")
    fun init():String{
        return "Web quiz starter"
    }

    @GetMapping("/quiz")
    fun getQuiz():Quiz{
        return Quiz(
            1,
            "First Quiz",
            "This is the first quiz",
            listOf("Option 1", "Option 2", "Option 3", "Option 4"),
            listOf(0)
        )
    }
}