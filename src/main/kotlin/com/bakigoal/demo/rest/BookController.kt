package com.bakigoal.demo.rest

import com.bakigoal.demo.service.BookService
import com.bakigoal.demo.dto.BookDto
import mu.KLogging
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(
    val bookService: BookService
) {

    companion object : KLogging() {
    }

    @GetMapping
    fun getAllBooks(): List<BookDto> {
        logger.info { "get All Books API is called..." }
        return bookService.getAllBooks()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): BookDto {
        logger.info { "get Book By Id API is called..." }
        return bookService.getBookById(id)
    }

    @PostMapping
    fun addBook(@RequestBody book: BookDto): BookDto {
        logger.info { "add Book API is called..." }
        return bookService.addBook(book)
    }

    @PutMapping("/{id}")
    fun updateBook(@RequestBody book: BookDto, @PathVariable id: Long): BookDto {
        logger.info { "update Book API is called..." }
        book.id = id
        return bookService.updateBook(book)
    }
}
