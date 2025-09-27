package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.UserRes
import com.reactkotlin.quiz.backend.entity.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService {
    fun createUser(email: String, password: String): UserRes

    fun findUserByEmail(email: String): User?
}