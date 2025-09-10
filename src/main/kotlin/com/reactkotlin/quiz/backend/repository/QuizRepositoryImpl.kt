package com.reactkotlin.quiz.backend.repository

import com.reactkotlin.quiz.backend.entity.Quiz
import org.springframework.stereotype.Repository

@Repository
class InMemoryQuizRepository : QuizRepository {
    private val quizzes = mutableListOf<Quiz>(
        Quiz.create("First Quiz", "This is the first quiz", listOf("Option 1", "Option 2", "Option 3", "Option 4"), listOf(0)),
        Quiz.create("Second Quiz", "This is the second quiz", listOf("Option 1", "Option 2", "Option 3", "Option 4"), listOf(1)),
        Quiz.create("Third Quiz", "This is the third quiz", listOf("Option 1", "Option 2", "Option 3", "Option 4"), listOf(2)),
        Quiz.create("Fourth Quiz", "This is the fourth quiz", listOf("Option 1", "Option 2", "Option 3", "Option 4"), listOf(3))
    )

    override fun add(quiz: Quiz): Quiz {
        quizzes.add(quiz)
        return quiz
    }

    override fun findAll(): List<Quiz> {
        return quizzes.toList()
    }

    override fun findById(id: Int): Quiz? {
        return quizzes.find { it.id == id }
    }

    override fun deleteById(id: Int) {
        quizzes.removeIf { it.id == id }
    }

    override fun update(quiz: Quiz): Quiz {
        quizzes.removeIf { it.id == quiz.id }
        quizzes.add(quiz)
        return quiz
    }
}