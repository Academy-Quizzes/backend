package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.RegisterUserReq
import com.reactkotlin.quiz.backend.service.UserServiceImpl
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.reactkotlin.quiz.backend.dto.UserRes
import com.reactkotlin.quiz.backend.service.UserService

@RestController
class UserController (
    private val userService : UserService
){
    private val log = LoggerFactory.getLogger(UserController::class.java)

    @PostMapping("/api/register")
    fun register(@Valid @RequestBody req: RegisterUserReq): ResponseEntity<Any> {
        log.info("Register user: $req.email")
        val user = userService.createUser(
            email = req.email,
            password = req.password
        )
        val response = UserRes(
            id = user.id,
            email = user.email,
            role = user.role
        )
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }
}