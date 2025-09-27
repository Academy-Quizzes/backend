package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.entity.User
import com.reactkotlin.quiz.backend.security.UserDetailsImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userService: UserService
): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = userService.findUserByEmail(username!!)
            ?: throw IllegalArgumentException("Invalid username or password.")
        return UserDetailsImpl(user)
    }
}