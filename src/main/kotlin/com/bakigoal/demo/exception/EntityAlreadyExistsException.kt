package com.bakigoal.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EntityAlreadyExistsException(id: Long) : ResponseStatusException(
    HttpStatus.CONFLICT,
    "Entity with id: $id is already exist"
)