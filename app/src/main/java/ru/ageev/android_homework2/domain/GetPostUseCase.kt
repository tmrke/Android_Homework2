package ru.ageev.android_homework2.domain

import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.repository.PostRepository
import ru.ageev.android_homework2.data.remote.repository.PostRepositoryImpl
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val repository: PostRepositoryImpl,
) {
    suspend fun execute(postId: String): Post {
        return repository.getPost(postId)
    }
}

