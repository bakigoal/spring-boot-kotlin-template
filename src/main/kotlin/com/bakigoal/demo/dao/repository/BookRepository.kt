package com.bakigoal.demo.dao.repository

import com.bakigoal.demo.dao.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>
