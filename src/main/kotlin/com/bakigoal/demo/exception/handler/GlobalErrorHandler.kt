package com.bakigoal.demo.exception.handler

import com.bakigoal.demo.exception.EntityAlreadyExists
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [EntityAlreadyExists::class])
    protected fun handleEntityAlreadyExists(ex: EntityAlreadyExists, request: ServletWebRequest): ResponseEntity<Any> {
        val bodyOfResponse = "Entity with id: ${ex.id} is already exists"
        val status = HttpStatus.CONFLICT
        val body = ErrorDto(status.value(), bodyOfResponse, request.request.servletPath)
        return ResponseEntity.status(status).body(body)
    }

    @ExceptionHandler(value = [RuntimeException::class])
    protected fun handleRuntimeException(ex: RuntimeException, request: ServletWebRequest): ResponseEntity<Any> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val body = ErrorDto(
            status.value(),
            ex.message ?: status.reasonPhrase,
            request.request.servletPath
        )
        return ResponseEntity.status(status).body(body)
    }
}