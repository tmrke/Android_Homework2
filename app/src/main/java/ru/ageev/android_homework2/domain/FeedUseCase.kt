package ru.ageev.android_homework2.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.repository.PostRepository
import javax.inject.Inject

class FeedUseCase @Inject constructor(
    private val repository: PostRepository,
) {
    suspend fun execute(): Flow<PagingData<Post>> {
        return repository.getFeed()
    }
}