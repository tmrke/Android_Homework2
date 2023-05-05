package ru.ageev.android_homework2.data.remote.repository

import ru.ageev.android_homework2.data.remote.NanopostAuthApiService
import javax.inject.Inject


class RegisterRepository @Inject constructor(
    private val apiAuthApiService: NanopostAuthApiService
) {
    fun checkUsername(username: String) {
        apiAuthApiService.checkUsername(username)
    }
}