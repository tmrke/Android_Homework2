package ru.ageev.android_homework2.domain

import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.android_homework2.data.remote.repository.RegisterRepository
import javax.inject.Inject

class CheckUsernameUseCase @Inject constructor(
    private val registerRepository: RegisterRepository
) {
    suspend fun execute(username: String) : CheckUsernameEnumResponse {
        return registerRepository.checkUsername(username)
    }
}