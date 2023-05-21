package ru.ageev.nanopost.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.data.remote.repository.PostRepository
import javax.inject.Inject

class FeedUseCase @Inject constructor(
    private val repository: PostRepository,
) {
    suspend fun execute(): Flow<PagingData<Post>> {
        return repository.getFeed()
    }
}