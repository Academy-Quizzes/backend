package com.reactkotlin.quiz.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuizController {

    @GetMapping("/")
    fun init():String{
        return "Web quiz starter"
    }
}