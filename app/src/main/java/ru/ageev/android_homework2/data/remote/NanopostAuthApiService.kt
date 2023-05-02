package ru.ageev.android_homework2.data.remote

import retrofit2.http.Body
import retrofit2.http.POST
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest

interface NanopostAuthApiService {
    @POST("api/auth/register")
    fun register(
        @Body registrationRequest: RegistrationRequest
    )
}