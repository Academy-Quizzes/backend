package com.reactkotlin.quiz.backend.validator

import com.reactkotlin.quiz.backend.dto.QuizReq
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [QuizReqValidator::class])
annotation class ValidQuizReq(
    val message: String = "Invalid quiz request",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class QuizReqValidator : ConstraintValidator<ValidQuizReq, QuizReq> {

    override fun isValid(value: QuizReq?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return true

        val optionsSize = value.options.size
        val answers = value.answers

        // rule 1 answers must not exceed options indices
        val invalidIndices = answers.filter { it !in 0 until optionsSize }
        if (invalidIndices.isNotEmpty()) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("Answers contain invalid indices: $invalidIndices")
                .addPropertyNode("answers")
                .addConstraintViolation()
            return false
        }

        // rule 2 answers size must not exceed options size
        if (answers.size > optionsSize) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("Answers cannot be larger than options")
                .addPropertyNode("answers")
                .addConstraintViolation()
            return false
        }

        // rule 3 enforce unique answers
        if (answers.size != answers.distinct().size) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("Duplicate answers are not allowed")
                .addPropertyNode("answers")
                .addConstraintViolation()
            return false
        }

        return true
    }
}