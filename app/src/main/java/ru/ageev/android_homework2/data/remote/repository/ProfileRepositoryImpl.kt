package ru.ageev.android_homework2.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.ageev.android_homework2.data.mappers.PostMapper
import ru.ageev.android_homework2.data.mappers.ProfileMapper
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.paging.PostPagingSource
import ru.ageev.android_homework2.data.remote.NanopostApiService
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: NanopostApiService,
    private val profileMapper: ProfileMapper,
    private val postsMapper: PostMapper
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
                postsMapper.toPost(apiPost)
            }
        }
    }

    override suspend fun subscribe(profileId: String) {
        apiService.subscribe(profileId)
    }
}