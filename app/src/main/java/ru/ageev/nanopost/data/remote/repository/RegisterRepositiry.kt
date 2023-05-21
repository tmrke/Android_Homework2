package ru.ageev.nanopost.data.remote.repository

import ru.ageev.nanopost.data.remote.NanopostAuthApiService
import ru.ageev.nanopost.data.remote.model.RegistrationRequest
import ru.ageev.nanopost.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.nanopost.data.remote.model.response.TokenResponse
import javax.inject.Inject


class RegisterRepository @Inject constructor(
    private val apiAuthApiService: NanopostAuthApiService,
) {
    suspend fun checkUsername(username: String): CheckUsernameEnumResponse {
        return apiAuthApiService.checkUsername(username).result
    }

    suspend fun register(registrationRequest: RegistrationRequest): TokenResponse {
        return apiAuthApiService.register(registrationRequest)
    }

    suspend fun login(registrationRequest: RegistrationRequest): TokenResponse {
        return apiAuthApiService.login(registrationRequest.username, registrationRequest.password)
    }
}