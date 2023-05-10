package ru.ageev.android_homework2.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.repository.ProfileRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: ProfileRepository
) {
    suspend fun execute(profileId: String): Flow<PagingData<Post>> {
        return repository.getProfilePosts(profileId)
    }
}