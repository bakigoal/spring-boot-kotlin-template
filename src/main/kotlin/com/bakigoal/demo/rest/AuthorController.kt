package com.bakigoal.demo.rest

import com.bakigoal.api.AuthorsApi
import com.bakigoal.demo.service.AuthorService
import com.bakigoal.model.AuthorDto
import mu.KLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController(
    val authorService: AuthorService
) : AuthorsApi {

    companion object : KLogging() {
    }

    override fun getAllAuthors(): ResponseEntity<List<AuthorDto>> {
        logger.info { "get All Author API is called..." }
        return ResponseEntity.ok(authorService.getAll())
    }
}
