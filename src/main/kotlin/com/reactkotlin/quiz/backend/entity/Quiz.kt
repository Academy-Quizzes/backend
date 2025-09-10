package com.reactkotlin.quiz.backend.entity


class Quiz(
    val id: Int,
    var title: String,
    var text: String,
    var options: List<String>,
    var answers: List<Int>
) {
    companion object {
        private var counter = 0

        fun create(title: String, text: String, options: List<String>, answers: List<Int>): Quiz {
            counter++
            return Quiz(
                id = counter,
                title = title,
                text = text,
                options = options,
                answers = answers
            )
        }
    }
}
