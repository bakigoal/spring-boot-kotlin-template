package com.bakigoal.demo.mapper

import com.bakigoal.demo.dto.BookDto
import com.bakigoal.demo.dao.entity.Book

fun Book.toDto(): BookDto {
    return BookDto(title, id)
}

fun BookDto.toEntity(): Book {
    return Book(title, id)
}