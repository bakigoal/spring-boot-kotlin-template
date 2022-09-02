package com.bakigoal.demo.rest

import com.bakigoal.demo.service.BookService
import com.bakigoal.demo.dto.BookDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
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
    @Operation(summary = "Get list of Books", description = "Returns 200 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "500", description = "Internal Error")
        ]
    )
    fun getAllBooks(): List<BookDto> {
        logger.info { "get All Books API is called..." }
        return bookService.getAllBooks()
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Book by id", description = "Returns 200 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Book not found")
        ]
    )
    fun getBook(@PathVariable id: Long): BookDto {
        logger.info { "get Book By Id API is called..." }
        return bookService.getBookById(id)
    }

    @PostMapping
    @Operation(summary = "Create Book", description = "Returns 200 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "500", description = "Internal Error")
        ]
    )
    fun addBook(@RequestBody book: BookDto): BookDto {
        logger.info { "add Book API is called..." }
        return bookService.addBook(book)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Book", description = "Returns 200 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Book not found")
        ]
    )
    fun updateBook(@RequestBody book: BookDto, @PathVariable id: Long): BookDto {
        logger.info { "update Book API is called..." }
        book.id = id
        return bookService.updateBook(book)
    }
}
