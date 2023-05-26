package xyz.ggos3.kotlinlibrary.service.book

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import xyz.ggos3.kotlinlibrary.domain.book.Book
import xyz.ggos3.kotlinlibrary.domain.book.BookRepository
import xyz.ggos3.kotlinlibrary.domain.user.UserRepository
import xyz.ggos3.kotlinlibrary.domain.user.loanhistory.UserLoanHistoryRepository
import xyz.ggos3.kotlinlibrary.dto.book.request.BookLoanRequest
import xyz.ggos3.kotlinlibrary.dto.book.request.BookRequest
import xyz.ggos3.kotlinlibrary.dto.book.request.BookReturnRequest

@Service
class BookService (
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {
    @Transactional
    fun saveBook(bookRequest: BookRequest) {
        val book = Book(bookRequest.name)
        bookRepository.save(book)
    }

    @Transactional
    fun loanBook(request: BookLoanRequest) {
        val book = bookRepository.findByName(request.bookName)
            ?: throw IllegalArgumentException()

        val user = userRepository.findByName(request.userName)
            ?: throw IllegalArgumentException()

        userLoanHistoryRepository.findByBookNameAndIsReturn(request.bookName, false)
            ?: throw IllegalArgumentException("진작에 대출 되어있는 책 입니다.")

        user.loanBook(book)
    }

    @Transactional
    fun returnBook(request: BookReturnRequest) {
        val user = userRepository.findByName(request.userName)
            ?: throw IllegalArgumentException()

        user.returnBook(request.bookName)
    }

}