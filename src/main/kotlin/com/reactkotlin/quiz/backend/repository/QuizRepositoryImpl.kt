package com.reactkotlin.quiz.backend.repository

import com.reactkotlin.quiz.backend.entity.Quiz
import org.springframework.stereotype.Repository

@Repository
class InMemoryQuizRepositoryImpl(private val quizzesDB: FakeQuizDB = FakeQuizDB()): QuizRepository {

    override fun add(quiz: Quiz): Quiz {
        quizzesDB.addQuiz(quiz)
        return quiz
    }

    override fun findAll(): List<Quiz> {
        return quizzesDB.getQuizzes()
    }

    override fun findById(id: Int): Quiz? {
        return quizzesDB.getQuiz(id)
    }

    override fun deleteById(id: Int) {
       quizzesDB.deleteQuiz(id)
    }

    override fun update(quiz: Quiz) {
        quizzesDB.updateQuiz(quiz)
    }
}

class FakeQuizDB {
    val dummyListOfQuizzesDB = mutableListOf(
        Quiz.create(
            "First Quiz",
            "This is the first quiz",
            listOf("Option 1", "Option 2", "Option 3", "Option 4"),
            listOf(0)
        ),
        Quiz.create(
            "Second Quiz",
            "This is the second quiz",
            listOf("Option 1", "Option 2", "Option 3", "Option 4"),
            listOf(1)
        ),
        Quiz.create(
            "Third Quiz",
            "This is the third quiz",
            listOf("Option 1", "Option 2", "Option 3", "Option 4"),
            listOf(2)
        ),
        Quiz.create(
            "Fourth Quiz",
            "This is the fourth quiz",
            listOf("Option 1", "Option 2", "Option 3", "Option 4"),
            listOf(3)
        )

    )

    fun getQuizzes(): List<Quiz> {
        return dummyListOfQuizzesDB
    }

    fun getQuiz(id: Int): Quiz? {
        return dummyListOfQuizzesDB.find { it.id == id }
    }

    fun addQuiz(quiz: Quiz) {
        dummyListOfQuizzesDB.add(quiz)
    }

    fun deleteQuiz(id: Int) {
        dummyListOfQuizzesDB.removeIf { it.id == id }
    }

    fun updateQuiz(quiz: Quiz) {
        dummyListOfQuizzesDB.removeIf { it.id == quiz.id }
        dummyListOfQuizzesDB.add(quiz)
    }


}