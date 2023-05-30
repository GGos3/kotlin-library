package xyz.ggos3.kotlinlibrary.dto.user.response

data class UserLoanHistoryResponse (
    val name: String,   // 유저 이름
    val books: List<BookHistoryResponse>
)

data class BookHistoryResponse(
    val name: String,   // 책이름
    val isReturn: Boolean   // 반납여부
)