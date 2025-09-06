package com.reactkotlin.quiz.backend.entity

import com.reactkotlin.quiz.backend.dto.QuizResFull
import com.reactkotlin.quiz.backend.dto.QuizResWithoutAnswer

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

    fun checkAnswer(submittedAnswer: List<Int>): Boolean {
        return submittedAnswer.sorted() == answer.sorted()
    }
}

fun Quiz.toResWithoutAnswer() = QuizResWithoutAnswer(id,title, text, options)
fun Quiz.toResFull()= QuizResFull(id,title, text, options, answer)




