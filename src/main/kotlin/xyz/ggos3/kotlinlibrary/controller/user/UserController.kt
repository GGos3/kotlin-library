package xyz.ggos3.kotlinlibrary.controller.user

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import xyz.ggos3.kotlinlibrary.dto.user.request.UserCreateRequest
import xyz.ggos3.kotlinlibrary.dto.user.request.UserUpdateRequest
import xyz.ggos3.kotlinlibrary.dto.user.response.UserLoanHistoryResponse
import xyz.ggos3.kotlinlibrary.dto.user.response.UserResponse
import xyz.ggos3.kotlinlibrary.service.user.UserService

@RestController
class UserController (
    private val userService: UserService
) {

    @PostMapping("/user")
    fun saveUser(@RequestBody request: UserCreateRequest) {
        userService.saveUser(request)
    }

    @GetMapping("/user")
    fun getUsers(): List<UserResponse> {
        return userService.getUsers()
    }

    @PutMapping("/user")
    fun updateUser(@RequestBody request: UserUpdateRequest) {
        userService.updateUserName(request)
    }

    @DeleteMapping("/user")
    fun deleteUser(name: String) {
        userService.deleteUser(name)
    }

    @GetMapping("/user/loan")
    fun getUserLoanHistories(): List<UserLoanHistoryResponse> {
        return userService.getUserLoanHistories()
    }

}