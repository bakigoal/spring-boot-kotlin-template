package com.bakigoal.demo.dao.entity

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var title: String,
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "book_author",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_name")]
    )
    var authors: Set<Author>? = HashSet()
)