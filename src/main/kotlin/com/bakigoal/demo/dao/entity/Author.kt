package com.bakigoal.demo.dao.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Author(
    @Id
    val name: String,
    val dateOfBirth: LocalDate?
)