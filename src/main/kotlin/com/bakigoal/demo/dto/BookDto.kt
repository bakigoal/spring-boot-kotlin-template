package com.bakigoal.demo.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Book Model")
data class BookDto(
    @JsonProperty("id")
    @field:Schema(
        description = "Book Id",
        example = "42",
        type = "int",
        minimum = "0",
        maximum = "999999999"
    )
    var id: Long?,

    @JsonProperty("title")
    @field:Schema(
        description = "Book Title",
        example = "Robin Good",
        type = "string"
    )
    var title: String,

    @JsonProperty("authors")
    @field:Schema(
        description = "Book Author List"
    )
    val authors: Set<AuthorDto> = HashSet()
)
