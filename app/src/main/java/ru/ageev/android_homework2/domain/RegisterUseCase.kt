package ru.ageev.android_homework2.domain

import ru.ageev.android_homework2.data.remote.repository.RegisterRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val registerRepository: RegisterRepository
) {
    fun execute(username: String) {
        registerRepository.checkUsername(username)
    }
}