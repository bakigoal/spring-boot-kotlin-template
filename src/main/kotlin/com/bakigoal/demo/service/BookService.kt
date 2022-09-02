package com.bakigoal.demo.service

import com.bakigoal.demo.dao.repository.BookRepository
import com.bakigoal.demo.exception.EntityAlreadyExistsException
import com.bakigoal.demo.exception.EntityNotFoundException
import com.bakigoal.demo.mapper.BookMapper
import com.bakigoal.model.BookDto
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BookService(
    val bookRepository: BookRepository,
    val bookMapper: BookMapper
) {

    fun getAllBooks(): List<BookDto> {
        return bookRepository.findAll().stream()
            .map { bookMapper.toDto(it) }
            .collect(Collectors.toList())
    }

    fun getBookById(id: Long): BookDto {
        return bookRepository.findById(id)
            .map { bookMapper.toDto(it) }
            .orElseThrow { EntityNotFoundException(id) }
    }

    fun addBook(book: BookDto): BookDto {
        if (book.id != null && bookRepository.existsById(book.id)) {
            throw EntityAlreadyExistsException(book.id)
        }
        val savedBook = bookRepository.save(bookMapper.toEntity(book))
        return bookMapper.toDto(savedBook)
    }

    fun updateBook(book: BookDto): BookDto {
        if (book.id == null || !bookRepository.existsById(book.id)) {
            throw EntityNotFoundException(book.id!!)
        }
        val savedBook = bookRepository.save(bookMapper.toEntity(book))
        return bookMapper.toDto(savedBook)
    }
}
