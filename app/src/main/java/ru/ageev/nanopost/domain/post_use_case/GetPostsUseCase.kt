package ru.ageev.nanopost.domain.post_use_case

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.domain.repository.ProfileRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: ProfileRepository
) {
    suspend fun execute(profileId: String): Flow<PagingData<Post>> {
        return repository.getProfilePosts(profileId)
    }
}