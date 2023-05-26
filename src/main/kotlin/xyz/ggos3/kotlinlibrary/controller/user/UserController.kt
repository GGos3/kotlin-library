package xyz.ggos3.kotlinlibrary.controller.user

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import xyz.ggos3.kotlinlibrary.domain.user.User
import xyz.ggos3.kotlinlibrary.dto.book.request.BookRequest
import xyz.ggos3.kotlinlibrary.dto.user.request.UserCreateRequest
import xyz.ggos3.kotlinlibrary.dto.user.request.UserUpdateRequest
import xyz.ggos3.kotlinlibrary.dto.user.response.UserResponse
import xyz.ggos3.kotlinlibrary.service.user.UserService

@Controller
class UserController (
    private val userService: UserService
) {

    @PostMapping
    fun saveUser(@RequestBody request: UserCreateRequest) {
        userService.saveUser(request)
    }

    @GetMapping
    fun getUsers(): List<UserResponse> {
        return userService.getUsers()
    }

    @PutMapping
    fun updateUser(@RequestBody request: UserUpdateRequest) {
        userService.updateUserName(request)
    }

    @DeleteMapping
    fun deleteUser(name: String) {
        userService.deleteUser(name)
    }


}