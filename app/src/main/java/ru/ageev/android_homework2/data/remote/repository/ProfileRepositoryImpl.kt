package ru.ageev.android_homework2.data.remote.repository

import ru.ageev.android_homework2.data.mappers.PostMapper
import ru.ageev.android_homework2.data.mappers.ProfileMapper
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.data.remote.NanopostApiService
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val apiService: NanopostApiService,
    private val profileMapper: ProfileMapper,
    private val postsMapper: PostMapper
) : ProfileRepository {
    override suspend fun getProfile(profilerId: String): Profile {
        return profileMapper.toProfile(apiService.getProfile(profilerId))
    }

    override suspend fun getPosts(profilerId: String): List<Post> {
        return postsMapper.toPosts(apiService.getPosts(profilerId))
    }
}