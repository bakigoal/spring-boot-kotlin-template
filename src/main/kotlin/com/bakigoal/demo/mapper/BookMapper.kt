package com.bakigoal.demo.mapper

import com.bakigoal.demo.dao.entity.Book
import com.bakigoal.model.BookDto
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface BookMapper {

    fun toDto(book: Book): BookDto

    fun toEntity(bookDto: BookDto): Book

    fun toEntity(bookDto: BookDto, @MappingTarget book: Book): Book
}