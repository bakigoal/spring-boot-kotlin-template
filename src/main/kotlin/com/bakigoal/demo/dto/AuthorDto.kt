package com.bakigoal.demo.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "Author Model")
data class AuthorDto(

    @JsonProperty("name")
    @field:Schema(
        description = "Author name",
        example = "Alexandr Pushkin",
        type = "string"
    )
    val name: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    @field:Schema(
        description = "Author date of birth",
        example = "1985-08-31",
        type = "string"
    )
    val dateOfBirth: LocalDate?
)
