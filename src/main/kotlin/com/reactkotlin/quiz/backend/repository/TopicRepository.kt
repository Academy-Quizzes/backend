package com.reactkotlin.quiz.backend.repository

import com.reactkotlin.quiz.backend.entity.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long>