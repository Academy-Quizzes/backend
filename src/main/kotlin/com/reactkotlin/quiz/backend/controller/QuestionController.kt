package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.QuestionAnswerReq
import com.reactkotlin.quiz.backend.dto.QuestionAnswerRes
import com.reactkotlin.quiz.backend.dto.QuestionReq
import com.reactkotlin.quiz.backend.dto.QuestionRes
import com.reactkotlin.quiz.backend.dto.QuestionResFull
import com.reactkotlin.quiz.backend.service.QuestionService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuestionController(private val questionService: QuestionService) {


    @GetMapping("/questions")
    fun getQuestions(): List<QuestionRes> {
        return questionService.getAll()
    }


    @GetMapping("/questions/{questionId}")
    fun getQuestion(@PathVariable questionId: Long): ResponseEntity<QuestionRes> {
        return ResponseEntity.ok(questionService.getById(questionId))
    }


    @PostMapping("/questions")
    fun addQuestion(@Valid @RequestBody question: QuestionReq): ResponseEntity<QuestionResFull> {
        val added = questionService.add(question)
        return ResponseEntity.status(HttpStatus.CREATED).body(added)
    }


    @PostMapping("/questions/{questionId}/solve")
    fun solveQuestion(@PathVariable questionId: Long, @RequestBody questionAnswer: QuestionAnswerReq): ResponseEntity<QuestionAnswerRes> {
        val answer = questionService.solve(questionId, questionAnswer.answers)
        return ResponseEntity.status(HttpStatus.OK).body(answer)
    }

    @DeleteMapping("/questions/{questionId}")
    fun deleteQuestion(@PathVariable questionId: Long): ResponseEntity<Unit> {
        questionService.delete(questionId)
        return ResponseEntity.noContent().build()
    }


    @PutMapping("/questions/{id}")
    fun updateQuestion(@PathVariable id: Long, @Valid @RequestBody question: QuestionReq): ResponseEntity<Unit> {
        questionService.update(id, question)
        return ResponseEntity.noContent().build()
    }

}