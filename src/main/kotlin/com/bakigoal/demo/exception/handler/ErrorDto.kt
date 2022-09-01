package com.bakigoal.demo.exception.handler

import java.sql.Timestamp
import java.time.Instant

data class ErrorDto(
    val status: Int,
    val error: String,
    val path: String,
    val timestamp: Timestamp = Timestamp.from(Instant.now())
)
