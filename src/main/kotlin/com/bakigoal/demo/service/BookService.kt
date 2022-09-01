package com.bakigoal.demo.service

import com.bakigoal.demo.dao.repository.BookRepository
import com.bakigoal.demo.dto.BookDto
import com.bakigoal.demo.exception.EntityAlreadyExists
import com.bakigoal.demo.exception.EntityNotFoundException
import com.bakigoal.demo.mapper.toDto
import com.bakigoal.demo.mapper.toEntity
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun getAllBooks(): List<BookDto> {
        return bookRepository.findAll().stream().map { it.toDto() }.collect(Collectors.toList())
    }

    fun getBookById(id: Long): BookDto {
        return bookRepository.findById(id).map { it.toDto() }.orElseThrow { EntityNotFoundException() }
    }

    fun addBook(book: BookDto): BookDto {
        if (book.id != null && bookRepository.existsById(book.id!!)) {
            throw EntityAlreadyExists(book.id!!)
        }
        return bookRepository.save(book.toEntity()).toDto()
    }

    fun updateBook(book: BookDto): BookDto {
        return bookRepository.save(book.toEntity()).toDto()
    }
}
