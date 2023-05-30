package xyz.ggos3.kotlinlibrary.domain.user

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import xyz.ggos3.kotlinlibrary.domain.book.Book
import xyz.ggos3.kotlinlibrary.domain.user.loanhistory.UserLoanHistory
import xyz.ggos3.kotlinlibrary.util.fail

@Entity
class User (
    var name: String,
    val age: Int?,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistory: MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    init {
        if (name.isBlank())
            fail("이름은 비어있을 수 없습니다.")
    }

    fun loanBook(book: Book) {
        this.userLoanHistory.add(UserLoanHistory(this, book.name))
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun returnBook(bookName: String) {
        this.userLoanHistory
            .first { history -> history.bookName == bookName }
            .doReturn()
    }
}