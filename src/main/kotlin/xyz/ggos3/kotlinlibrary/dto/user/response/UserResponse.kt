package xyz.ggos3.kotlinlibrary.dto.user.response

import xyz.ggos3.kotlinlibrary.domain.user.User

data class UserResponse (
    val user: User
) {
    val id: Long = user.id!!
    val name: String = user.name
    val age: Int? = user.age
}