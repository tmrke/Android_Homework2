package ru.ageev.android_homework2.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface NanopostApiService {
    @GET("api/v1/profile/{profileId}")
    suspend fun getProfile(
        @Path("profileId") profileId: String
    ): ApiProfile

}