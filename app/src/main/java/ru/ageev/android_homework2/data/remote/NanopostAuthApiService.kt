package ru.ageev.android_homework2.data.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import ru.ageev.android_homework2.data.remote.model.RegistrationRequest
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameEnumResponse
import ru.ageev.android_homework2.data.remote.model.response.CheckUsernameResponse

interface NanopostAuthApiService {

    @GET("api/auth/checkUsername")
    suspend fun checkUsername(
        @Query("username") username: String
    ): CheckUsernameResponse



    @POST("api/auth/register")
    fun register(
        @Body registrationRequest: RegistrationRequest
    )
}