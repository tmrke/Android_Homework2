package ru.ageev.nanopost.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import ru.ageev.nanopost.data.mappers.PostMapper
import ru.ageev.nanopost.data.mappers.ProfileCompactMapper
import ru.ageev.nanopost.data.mappers.ProfileMapper
import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.data.model.Profile
import ru.ageev.nanopost.data.model.ProfileCompact
import ru.ageev.nanopost.data.paging.PostPagingSource
import ru.ageev.nanopost.data.paging.ProfilePagingSource
import ru.ageev.nanopost.data.remote.NanopostApiService
import ru.ageev.nanopost.data.remote.model.EditProfileRequest
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: NanopostApiService,
    private val profileMapper: ProfileMapper,
    private val postMapper: PostMapper,
    private val profileCompactMapper: ProfileCompactMapper,
) : ProfileRepository {
    override suspend fun getProfile(profileId: String): Profile {
        return profileMapper.toProfile(apiService.getProfile(profileId))
    }

    override suspend fun getProfilePosts(profileId: String): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(30, enablePlaceholders = false),
            pagingSourceFactory = { PostPagingSource(apiService, profileId) }
        ).flow.map { pagingData ->
            pagingData.map { apiPost ->
                postMapper.toPost(apiPost)
            }
        }
    }

    override suspend fun searchProfile(query: String): Flow<PagingData<ProfileCompact>> {
        return Pager(
            config = PagingConfig(30, enablePlaceholders = false),
            pagingSourceFactory = { ProfilePagingSource(query, apiService) }
        ).flow.map { pagingData ->
            pagingData.map { profile ->
                profileCompactMapper.toProfileCompact(profile)
            }
        }
    }

    override suspend fun subscribe(profileId: String) {
        apiService.subscribe(profileId)
    }

    override suspend fun unsubscribe(profileId: String) {
        apiService.unsubscribe(profileId)
    }

    override suspend fun editProfile(editProfileRequest: EditProfileRequest) {
        val requestBody = editProfileRequest.avatar?.let { avatarByteArray ->
            MultipartBody.Part.createFormData(
                "avatar",
                "avatar.jpg",
                avatarByteArray.toRequestBody("image/*".toMediaType())
            )
        }

        apiService.editProfile(
            editProfileRequest.profileId,
            editProfileRequest.displayName?.toRequestBody(),
            editProfileRequest.bio?.toRequestBody(),
            requestBody
        )
    }
}