package com.bakigoal.demo.rest

import com.bakigoal.demo.dto.AuthorDto
import com.bakigoal.demo.service.AuthorService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/authors")
class AuthorController(
    val authorService: AuthorService
) {

    companion object : KLogging() {
    }

    @GetMapping
    fun getAll(): List<AuthorDto> {
        logger.info { "get All Author API is called..." }
        return authorService.getAll()
    }
}
