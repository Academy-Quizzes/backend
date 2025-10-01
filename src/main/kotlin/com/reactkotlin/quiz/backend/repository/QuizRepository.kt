package com.reactkotlin.quiz.backend.repository

import com.reactkotlin.quiz.backend.entity.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuizRepository : JpaRepository<Quiz, Long>