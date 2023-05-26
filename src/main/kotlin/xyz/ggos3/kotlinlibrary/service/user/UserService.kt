package xyz.ggos3.kotlinlibrary.service.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import xyz.ggos3.kotlinlibrary.domain.user.User
import xyz.ggos3.kotlinlibrary.domain.user.UserRepository
import xyz.ggos3.kotlinlibrary.dto.user.request.UserCreateRequest
import xyz.ggos3.kotlinlibrary.dto.user.request.UserUpdateRequest
import xyz.ggos3.kotlinlibrary.dto.user.response.UserResponse

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val user = User(request.name, request.age)

        userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUsers(): List<UserResponse> {
        return userRepository.findAll()
            .map { user -> UserResponse(user) }
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest) {
        val user = userRepository.findById(request.id)
            .orElseThrow(::IllegalArgumentException)

        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
        val user = userRepository.findByName(name)
            ?: throw IllegalArgumentException()

        userRepository.delete(user)
    }
}