package com.reactkotlin.quiz.backend.entity

import com.reactkotlin.quiz.backend.dto.QuizReq
import com.reactkotlin.quiz.backend.dto.QuizRes

class Quiz(
    val id: Int,
    var title: String,
    var text: String,
    var options: List<String>,
    var answer: List<Int>
){
    companion object {
        private var counter = 0

        fun create(title: String, text: String, options: List<String>, answer: List<Int>): Quiz {
            counter++
            return Quiz(id = counter, title = title, text = text, options = options, answer = answer)
        }
    }
}

fun Quiz.toRes() = QuizRes(id,title, text, options)




