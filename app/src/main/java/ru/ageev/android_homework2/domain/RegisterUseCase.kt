package ru.ageev.android_homework2.domain

import ru.ageev.android_homework2.data.PrefsStorage
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.repository.RegisterRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val registerRepository: RegisterRepository
) {
    fun execute(registrationRequest: RegistrationRequest) : PrefsStorage {
        return registerRepository.register(registrationRequest)
    }
}