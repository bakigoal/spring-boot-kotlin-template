package com.bakigoal.demo.service

import com.bakigoal.demo.dao.repository.AuthorRepository
import com.bakigoal.demo.dto.AuthorDto
import com.bakigoal.demo.mapper.AuthorMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AuthorService(
    val authorRepository: AuthorRepository,
    val authorMapper: AuthorMapper
) {
    fun getAll(): List<AuthorDto> {
        return authorRepository.findAll().stream()
            .map { authorMapper.toDto(it) }
            .collect(Collectors.toList())
    }
}
