package com.reactkotlin.quiz.backend.entity

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
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


@Entity
@Table(name = "question")
class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var text: String,

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = [JoinColumn(name = "question_id")])
    @Column(name = "options")
    var options: List<String> = listOf(),

    @ElementCollection
    @CollectionTable(name = "question_answers", joinColumns = [JoinColumn(name = "question_id")])
    @Column(name = "answers")
    var answers: List<Int> = listOf(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "question_topics",
        joinColumns = [JoinColumn(name = "question_id")],
        inverseJoinColumns = [JoinColumn(name = "topic_id")]
    )
    var topics: MutableSet<Topic> = mutableSetOf(),

    @JoinColumn(name = "creator_id", nullable = false)
    var creatorId:Long? = null
)
