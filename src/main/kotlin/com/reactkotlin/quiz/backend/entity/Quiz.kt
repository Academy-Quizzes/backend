package com.reactkotlin.quiz.backend.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "quizzes")
class Quiz (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column (nullable=false)
    var title: String =" ",

    @Column(nullable=false)
    var description: String=" ",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = true)
    var topic: Topic? = null,


    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDate = LocalDate.now(),

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
        name = "quiz_questions",
        joinColumns = [JoinColumn(name = "quiz_id")],
        inverseJoinColumns = [JoinColumn(name = "question_id")]
    )
    var questions: MutableList<Question> = mutableListOf()

)