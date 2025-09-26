package com.reactkotlin.quiz.backend.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
    private val id: Long,
    private val email: String,
    private val password: String,
    private val authorities: Collection<GrantedAuthority>,
    private val enabled: Boolean
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }


    override fun getUsername(): String {
        return email
    }

    override fun getPassword(): String {
        return password
    }

    fun getId(): Long {
        return id
    }
}