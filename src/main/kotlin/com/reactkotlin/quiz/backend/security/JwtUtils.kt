package com.reactkotlin.quiz.backend.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import java.nio.charset.StandardCharsets
import java.util.Date
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

object JwtUtils {
    private const val ENV_JWT_SECRET = "JWT_SECRET"
    private const val CLAIM_ROLES = "roles"
    private const val CLAIM_ID = "id"
    private const val EXPIRATION_TIME = 86_400_000L // 24h

    private val SECRET_KEY_STRING: String = System.getenv(ENV_JWT_SECRET)
        ?: throw IllegalStateException("$ENV_JWT_SECRET environment variable not set")

    private val SECRET_KEY: SecretKey = SecretKeySpec(
        SECRET_KEY_STRING.toByteArray(StandardCharsets.UTF_8),
        SignatureAlgorithm.HS512.jcaName
    )

    fun generateToken(userDetails: UserDetails): String {
        return Jwts.builder()
            .setSubject(userDetails.username) // it's email
            .claim(CLAIM_ROLES, userDetails.authorities.map { it.authority })
            .claim(CLAIM_ID, (userDetails as? UserDetailsImpl)?.getId())
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SECRET_KEY)
            .compact()
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        return try {
            val username = extractUsername(token)
            username == userDetails.username && !isTokenExpired(token)
        } catch (e: Exception) {
            false
        }
    }

    fun extractUsername(token: String): String {
        return Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .body
            .subject
    }

    private fun isTokenExpired(token: String): Boolean {
        return Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .body
            .expiration
            .before(Date())
    }
}