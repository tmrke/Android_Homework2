package ru.ageev.android_homework2.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.ageev.android_homework2.data.remote.model.ApiPost
import ru.ageev.android_homework2.data.remote.model.ApiProfile
import ru.ageev.android_homework2.data.remote.repository.PagedDataResponse

interface NanopostApiService {
    @GET("api/v1/profile/{profileId}")
    suspend fun getProfile(
        @Path("profileId") profileId: String
    ): ApiProfile

    @GET("api/v1/posts/{profileId}")
    suspend fun getProfilePosts(
        @Path("profileId") profileId: String,
        @Query("count") count: Int,
        @Query("offset") offset:String?
    ): PagedDataResponse<ApiPost>

}