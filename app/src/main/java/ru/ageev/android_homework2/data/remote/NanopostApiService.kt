package ru.ageev.android_homework2.data.remote

import android.app.DownloadManager.Request
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import ru.ageev.android_homework2.data.remote.model.ApiImage
import ru.ageev.android_homework2.data.remote.model.ApiPost
import ru.ageev.android_homework2.data.remote.model.ApiProfile
import ru.ageev.android_homework2.data.remote.model.response.ResultResponse
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
        @Query("offset") offset: String?
    ): PagedDataResponse<ApiPost>

    @DELETE("api/v1/post/{postId}")
    suspend fun deletePost(
        @Path("postId") postId: String
    ): ResultResponse

    @GET("api/v1/post/{postId}")
    suspend fun getPost(
        @Path("postId") postId: String
    ): ApiPost

    @PUT("api/v1/post")
    @Multipart
    suspend fun createPost(
        @Part("text") text: RequestBody?,
        @Part image1: MultipartBody.Part?,
        @Part image2: MultipartBody.Part?,
        @Part image3: MultipartBody.Part?,
        @Part image4: MultipartBody.Part?,
    ): ApiPost

    @PUT("api/v1/profile/{profileId}/subscribe")
    suspend fun subscribe(
        @Path("profileId") profileId: String
    ): ResultResponse

    @GET("api/v1/feed")
    suspend fun getFeed(
        @Query("count") count: Int,
        @Query("offset") offset: String?
    ): PagedDataResponse<ApiPost>

    @GET("api/v1/images/{profileId}")
    suspend fun getAllImages(
        @Path("profileId") profileId: String,
        @Query("count") count: Int,
        @Query("offset") offset: String?
    ): PagedDataResponse<ApiImage>
}