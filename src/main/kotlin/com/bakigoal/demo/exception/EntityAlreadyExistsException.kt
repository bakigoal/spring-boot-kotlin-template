package com.bakigoal.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class EntityAlreadyExistsException(val id: Long): RuntimeException() {
}