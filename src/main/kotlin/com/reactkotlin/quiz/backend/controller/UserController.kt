package com.reactkotlin.quiz.backend.controller

import com.reactkotlin.quiz.backend.dto.LoginReq
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
import com.reactkotlin.quiz.backend.security.JwtUtils
import com.reactkotlin.quiz.backend.security.UserDetailsImpl
import com.reactkotlin.quiz.backend.service.UserService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails

@RestController
class UserController (
    private val userService : UserService,
    private val authenticationManager: AuthenticationManager,
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

    @PostMapping("/api/login")
    fun login(@Valid @RequestBody req: LoginReq): ResponseEntity<Any> {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                req.email,
                req.password
            )
        )
        val userDetails = authentication.principal as UserDetails
        val jwtToken = JwtUtils.generateToken(userDetails)
        val userRes = mapOf(
            "id" to (userDetails as UserDetailsImpl).getId(),
            "email" to userDetails.username,
            "role" to userDetails.authorities.first().authority.replace("ROLE_", "")
        )
        return ResponseEntity.ok(mapOf("token" to jwtToken, "user" to userRes))
    }
}