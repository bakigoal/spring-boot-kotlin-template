package com.bakigoal.demo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class BookDto(
    @JsonProperty("id")
    var id: Long?,
    @JsonProperty("title")
    var title: String
)
