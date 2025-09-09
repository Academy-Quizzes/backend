package com.reactkotlin.quiz.backend.repository

import com.reactkotlin.quiz.backend.entity.Quiz

interface QuizRepository {
    fun add(quiz: Quiz): Quiz

    fun findAll(): List<Quiz>

    fun findById(id: Int): Quiz?

    fun deleteById(id: Int)

    fun update(quiz: Quiz):Quiz
}