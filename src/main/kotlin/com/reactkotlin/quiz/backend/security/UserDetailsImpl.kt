package com.reactkotlin.quiz.backend.security
import com.reactkotlin.quiz.backend.entity.User
import com.reactkotlin.quiz.backend.entity.asGrantedAuthority
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
    private val user: User,
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf(user.role.asGrantedAuthority)
    }

    override fun getUsername(): String = user.email

    override fun getPassword(): String = user.password

    fun getId(): Long? = user.id

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = user.enabled
}