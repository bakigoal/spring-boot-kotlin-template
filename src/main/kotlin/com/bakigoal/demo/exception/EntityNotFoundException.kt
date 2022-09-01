package com.bakigoal.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EntityNotFoundException : ResponseStatusException(
    HttpStatus.NOT_FOUND,
    "No entity found with given id"
)
