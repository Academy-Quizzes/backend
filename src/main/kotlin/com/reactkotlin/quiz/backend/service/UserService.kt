package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.UserRes
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {
    fun createUser(email: String, password: String): UserRes
}