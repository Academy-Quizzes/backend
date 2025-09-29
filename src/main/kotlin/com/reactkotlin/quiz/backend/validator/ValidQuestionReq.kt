package com.reactkotlin.quiz.backend.validator

import com.reactkotlin.quiz.backend.dto.QuestionReq
import com.reactkotlin.quiz.backend.repository.TopicRepository
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [QuestionReqValidator::class])
annotation class ValidQuestionReq(
    val message: String = "Invalid question request",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

@Component
class QuestionReqValidator(
    private val topicRepository: TopicRepository,
) : ConstraintValidator<ValidQuestionReq, QuestionReq> {

    override fun isValid(value: QuestionReq?, context: ConstraintValidatorContext): Boolean {
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

        // rule 4 answers cannot be empty
        if (answers.isEmpty()) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("Answers cannot be empty")
                .addPropertyNode("answers")
                .addConstraintViolation()
            return false
        }

        // rule 5: topicIds must not be empty
        if (value.topicIds.isEmpty()) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("At least one topic must be specified")
                .addPropertyNode("topicIds")
                .addConstraintViolation()
            return false
        }

        // rule 6: all topic ids must exist in db
        val foundTopics = topicRepository.findAllById(value.topicIds)
        if (foundTopics.size != value.topicIds.distinct().size) {
            context.disableDefaultConstraintViolation()
            context.buildConstraintViolationWithTemplate("Some topicIds do not exist: ${value.topicIds}")
                .addPropertyNode("topicIds")
                .addConstraintViolation()
            return false
        }

        return true
    }
}