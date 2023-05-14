package ru.ageev.android_homework2.domain.auth_use_case

import ru.ageev.android_homework2.data.PrefsStorage
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.model.response.TokenResponse
import ru.ageev.android_homework2.data.remote.repository.RegisterRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val registerRepository: RegisterRepository
) {
    suspend fun execute(registrationRequest: RegistrationRequest) : TokenResponse {
        return registerRepository.register(registrationRequest)
    }
}