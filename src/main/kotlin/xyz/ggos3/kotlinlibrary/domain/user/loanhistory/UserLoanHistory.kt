package xyz.ggos3.kotlinlibrary.domain.user.loanhistory

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import xyz.ggos3.kotlinlibrary.domain.user.User

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,
    val bookName: String,
    var isReturn: Boolean = false,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    fun doReturn() {
        this.isReturn = true
    }
}