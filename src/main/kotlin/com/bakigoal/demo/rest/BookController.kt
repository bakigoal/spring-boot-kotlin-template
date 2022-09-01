package com.bakigoal.demo.rest

import com.bakigoal.demo.service.BookService
import com.bakigoal.demo.dto.BookDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController(
    val bookService: BookService
) {

    @GetMapping
    fun getAllBooks(): List<BookDto> {
        return bookService.getAllBooks()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): BookDto {
        return bookService.getBookById(id)
    }

    @PostMapping
    fun addBook(@RequestBody book: BookDto): BookDto {
        return bookService.addBook(book)
    }

    @PutMapping("/{id}")
    fun updateBook(@RequestBody book: BookDto, @PathVariable id: Long): BookDto {
        book.id = id
        return bookService.updateBook(book)
    }
}
