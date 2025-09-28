package com.reactkotlin.quiz.backend.service

import com.reactkotlin.quiz.backend.dto.UserRes
import com.reactkotlin.quiz.backend.entity.User
import com.reactkotlin.quiz.backend.repository.RoleRepository
import com.reactkotlin.quiz.backend.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserServiceImpl(
    private val userRepo: UserRepository,
    private val roleRepo: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {
    @Transactional
    override fun createUser(email: String, password: String): UserRes {
        if (userRepo.existsByEmail(email)) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "User with email=$email already exists")
        }

        val userRole = roleRepo.findByName("USER")
            ?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Role USER not found")

        val savedUser = userRepo.save(
            User(
                email = email,
                password = passwordEncoder.encode(password),
                roles = mutableSetOf(userRole)
            )
        )
        return UserRes(
            id = savedUser.id,
            email = savedUser.email,
            roles = savedUser.roles
        )
    }
    @Transactional
    override fun findUserByEmail(email: String): User? {
        return userRepo.findByEmail(email)
    }

}