package ru.ageev.nanopost.domain.repository


import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.data.model.Profile
import ru.ageev.nanopost.data.model.ProfileCompact
import ru.ageev.nanopost.data.remote.model.EditProfileRequest


interface ProfileRepository {
    suspend fun getProfile(profileId: String): Profile

    suspend fun getProfilePosts(profileId: String): Flow<PagingData<Post>>

    suspend fun subscribe(profileId: String)

    suspend fun unsubscribe(profileId: String)

    suspend fun editProfile(editProfileRequest: EditProfileRequest)

    suspend fun searchProfile(query: String): Flow<PagingData<ProfileCompact>>
}