package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.UserRes
import com.reactkotlin.quiz.backend.entity.Role
import com.reactkotlin.quiz.backend.entity.User
import com.reactkotlin.quiz.backend.repository.UserRepository
import com.reactkotlin.quiz.backend.security.UserDetailsImpl
import org.springframework.http.HttpStatus
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

@Service
class UserServiceImpl(
    private val userRepo: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? =
        userRepo.findByEmail(username!!)?.let {
            UserDetailsImpl(
                it.id!!,
                it.email,
                it.password,
                listOf(SimpleGrantedAuthority("ROLE_USER")),
                it.enabled,
            )
        } ?: throw UsernameNotFoundException("User not found")

    fun createUser(email: String, password: String): UserRes {
        if (userRepo.existsByEmail(email)) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "User with email=$email already exists")
        }
        val defaultRole = Role.USER.name
        val savedUser = userRepo.save(
            User(
                email = email,
                password = passwordEncoder.encode(password),
                role = Role.USER
            )
        )
        return UserRes(
            id = savedUser.id,
            email = savedUser.email,
            role = savedUser.role
        )
    }

}