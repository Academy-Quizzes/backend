package com.reactkotlin.quiz.backend.repository

import com.reactkotlin.quiz.backend.entity.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<Question, Long>