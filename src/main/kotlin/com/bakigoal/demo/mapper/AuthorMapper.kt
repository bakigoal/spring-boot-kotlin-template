package com.bakigoal.demo.mapper

import com.bakigoal.demo.dao.entity.Author
import com.bakigoal.demo.dto.AuthorDto
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface AuthorMapper {

    fun toDto(author: Author): AuthorDto
}
