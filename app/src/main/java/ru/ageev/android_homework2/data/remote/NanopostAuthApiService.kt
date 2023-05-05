package ru.ageev.android_homework2.data.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse

interface NanopostAuthApiService {

    @GET("api/auth/checkUsername/{username}")
    suspend fun checkUsername(
        @Path("username") username: String
    ): CheckUsernameEnumResponse


    @POST("api/auth/register")
    fun register(
        @Body registrationRequest: RegistrationRequest
    )
}