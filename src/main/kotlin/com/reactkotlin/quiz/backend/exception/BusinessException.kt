package com.reactkotlin.quiz.backend.exception


class QuestionNotFoundException(val questionId: Long) : RuntimeException()

