package com.bakigoal.demo.exception.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class GlobalErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ResponseStatusException::class])
    protected fun handleResponseStatusException(
        ex: ResponseStatusException,
        request: ServletWebRequest
    ): ResponseEntity<Any> {
        val status = ex.status
        val body = ErrorDto(
            status.value(),
            ex.message,
            request.request.servletPath
        )
        logger.error("Error: ${ex.stackTraceToString()}")
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
        logger.error("Error: ${ex.stackTraceToString()}")
        return ResponseEntity.status(status).body(body)
    }
}