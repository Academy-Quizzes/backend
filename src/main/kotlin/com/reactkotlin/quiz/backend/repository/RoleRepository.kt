package com.reactkotlin.quiz.backend.repository

import com.reactkotlin.quiz.backend.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long>{
    fun findByName(name: String): Role?
}
