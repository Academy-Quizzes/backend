package com.reactkotlin.quiz.backend.exception


class QuizNotFoundException(val quizId: Long) : RuntimeException()

