package xyz.ggos3.kotlinlibrary.dto.book.request

import xyz.ggos3.kotlinlibrary.domain.book.BookType

data class BookRequest (
    val name: String,
    val type: BookType
)