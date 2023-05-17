package ru.ageev.android_homework2.data.remote.repository


import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.remote.model.EditProfileRequest


interface ProfileRepository {
    suspend fun getProfile(profileId: String): Profile

    suspend fun getProfilePosts(profileId: String): Flow<PagingData<Post>>

    suspend fun subscribe(profileId: String)

    suspend fun editProfile(editProfileRequest: EditProfileRequest)
}