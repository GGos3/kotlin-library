package xyz.ggos3.kotlinlibrary.controller.book

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import xyz.ggos3.kotlinlibrary.dto.book.request.BookLoanRequest
import xyz.ggos3.kotlinlibrary.dto.book.request.BookRequest
import xyz.ggos3.kotlinlibrary.dto.book.request.BookReturnRequest
import xyz.ggos3.kotlinlibrary.service.book.BookService

@Controller
class BookController (
    private val bookService: BookService
) {
    @PostMapping("/book")
    fun saveBook(@RequestBody bookRequest: BookRequest) {
        bookService.saveBook(bookRequest)
    }

    @PostMapping("/book/loan")
    fun loanBook(@RequestBody bookLoanRequest: BookLoanRequest) {
        bookService.loanBook(bookLoanRequest)
    }

    @PutMapping("/book/return")
    fun returnBook(@RequestBody request: BookReturnRequest) {
        bookService.returnBook(request)
    }
}