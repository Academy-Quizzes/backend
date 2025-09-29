package com.reactkotlin.quiz.backend.dataseeder

import com.reactkotlin.quiz.backend.entity.Role
import com.reactkotlin.quiz.backend.entity.User
import com.reactkotlin.quiz.backend.repository.RoleRepository
import com.reactkotlin.quiz.backend.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class DataSeederConfig {

    private val log = LoggerFactory.getLogger(DataSeederConfig::class.java)

    companion object {
        private const val ENV_TEST1_PASS = "TEST1_PASS"
        private const val ENV_TEST2_PASS = "TEST2_PASS"
        private const val ENV_TEST3_PASS = "TEST3_PASS"
        private const val ENV_TEST4_PASS = "TEST4_PASS"
    }

    private val test1Pass: String = System.getenv(ENV_TEST1_PASS)
    private val test2Pass: String = System.getenv(ENV_TEST2_PASS)
    private val test3Pass: String = System.getenv(ENV_TEST3_PASS)
    private val test4Pass: String = System.getenv(ENV_TEST4_PASS)

    @Bean
    fun dataSeeder(
        roleRepository: RoleRepository,
        userRepository: UserRepository,
        passwordEncoder: PasswordEncoder
    ) = CommandLineRunner {

        val roles = listOf("USER", "CREATOR", "ADMIN").associateWith { name ->
            roleRepository.findByName(name) ?: roleRepository.save(Role(name = name))
        }

        fun seedUser(email: String, rawPassword: String, roleNames: List<String>) {
            if (userRepository.findByEmail(email) == null) {
                val userRoles = roleNames.mapNotNull { roles[it] }.toMutableSet()
                userRepository.save(
                    User(
                        email = email,
                        password = passwordEncoder.encode(rawPassword),
                        roles = userRoles
                    )
                )
                log.info("✅ Seeded $email with roles $roleNames")
            }
        }

        seedUser("test1@abv.bg", test1Pass, listOf("USER", "CREATOR", "ADMIN")) // turbo admin
        seedUser("test2@abv.bg", test2Pass, listOf("USER"))                     // normal user from when he registers
        seedUser("test3@abv.bg", test3Pass, listOf("USER", "CREATOR"))          // creator and user
        seedUser("test4@abv.bg", test4Pass, listOf("CREATOR"))                  // only creator
    }
}