package ru.ageev.nanopost.domain.auth_use_case

import ru.ageev.nanopost.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.nanopost.data.repository.RegisterRepository
import javax.inject.Inject

class CheckUsernameUseCase @Inject constructor(
    private val registerRepository: RegisterRepository
) {
    suspend fun execute(username: String) : CheckUsernameEnumResponse {
        return registerRepository.checkUsername(username)
    }
}