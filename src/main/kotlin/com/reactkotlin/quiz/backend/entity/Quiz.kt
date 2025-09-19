package com.reactkotlin.quiz.backend.entity

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table


@Entity
@Table(name = "quiz")
class Quiz(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var text: String,

    @ElementCollection
    @CollectionTable(name = "quiz_options", joinColumns = [JoinColumn(name = "quiz_id")])
    @Column(name = "options")
    var options: List<String> = listOf(),

    @ElementCollection
    @CollectionTable(name = "quiz_answers", joinColumns = [JoinColumn(name = "quiz_id")])
    @Column(name = "answers")
    var answers: List<Int> = listOf()
)
