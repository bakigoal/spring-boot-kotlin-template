package com.bakigoal.demo.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class AuthorDto(
    @JsonProperty("id")
    var id: Long?,
    @JsonProperty("name")
    val name: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val dateOfBirth: LocalDate?
)
