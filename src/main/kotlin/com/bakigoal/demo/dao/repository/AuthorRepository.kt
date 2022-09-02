package com.bakigoal.demo.dao.repository

import com.bakigoal.demo.dao.entity.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, String>
