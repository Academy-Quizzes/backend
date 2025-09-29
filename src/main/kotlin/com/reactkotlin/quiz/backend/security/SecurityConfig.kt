package com.reactkotlin.quiz.backend.security

import com.reactkotlin.quiz.backend.service.UserDetailsServiceImpl
import com.reactkotlin.quiz.backend.service.UserService
import jakarta.servlet.DispatcherType
import org.hibernate.internal.CoreLogging.logger
import org.springframework.aot.generate.ValueCodeGenerator.withDefaults
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class SecurityConfig {


    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(userService: UserService): UserDetailsService {
        return UserDetailsServiceImpl(userService)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .csrf { it.disable() }
            .headers { it.frameOptions { c -> c.disable() } }
            .exceptionHandling {
                it.authenticationEntryPoint { req, response, ex ->
                    response.sendError(401)
                }
                it.accessDeniedHandler { req, response, ex ->
                    response.sendError(403)
                }
            }
            .authorizeHttpRequests { auth ->
                auth.dispatcherTypeMatchers(
                    DispatcherType.ERROR,
                    DispatcherType.FORWARD
                ).permitAll()
                auth
                    .requestMatchers(HttpMethod.POST, "/api/register").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/refresh-token").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/logout").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/quizzes").permitAll()
//                    .requestMatchers(HttpMethod.POST, "/api/quizzes").hasAnyRole("CREATOR", "ADMIN")
//                    .requestMatchers(HttpMethod.POST, "/api/quizzes").hasAuthority("ROLE_CREATOR")
                    .anyRequest().authenticated()
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .httpBasic { }
            .build()

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:5173")
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
        configuration.allowedHeaders = listOf("*")
        configuration.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}



