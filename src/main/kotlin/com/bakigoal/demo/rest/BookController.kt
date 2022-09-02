package com.bakigoal.demo.rest

import com.bakigoal.api.BooksApi
import com.bakigoal.demo.service.BookService
import com.bakigoal.model.BookDto
import mu.KLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    val bookService: BookService
) : BooksApi {

    companion object : KLogging() {
    }

    override fun getAllBooks(): ResponseEntity<List<BookDto>> {
        logger.info { "get All Books API is called..." }
        return ResponseEntity.ok(bookService.getAllBooks())
    }

    override fun getBook(@PathVariable("id") id: Long): ResponseEntity<BookDto> {
        logger.info { "get Book By Id API is called..." }
        return ResponseEntity.ok(bookService.getBookById(id))
    }

    override fun createBook(bookDto: BookDto): ResponseEntity<BookDto> {
        logger.info { "add Book API is called..." }
        return ResponseEntity.ok(bookService.addBook(bookDto))
    }

    override fun updateBook(id: Long, bookDto: BookDto): ResponseEntity<BookDto> {
        logger.info { "update Book API is called..." }
        return ResponseEntity.ok(bookService.updateBook(bookDto))
    }
}
