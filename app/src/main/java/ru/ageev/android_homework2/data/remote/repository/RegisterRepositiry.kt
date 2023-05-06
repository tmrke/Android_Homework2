package ru.ageev.android_homework2.data.remote.repository

import ru.ageev.android_homework2.data.remote.NanopostAuthApiService
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import javax.inject.Inject


class RegisterRepository @Inject constructor(
    private val apiAuthApiService: NanopostAuthApiService
) {
    suspend fun checkUsername(username: String) : CheckUsernameEnumResponse {
        return apiAuthApiService.checkUsername(username).result

    }
}