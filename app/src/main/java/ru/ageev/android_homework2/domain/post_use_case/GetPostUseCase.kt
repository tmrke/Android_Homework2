package ru.ageev.android_homework2.domain.post_use_case

import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.repository.PostRepositoryImpl
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val repository: PostRepositoryImpl,
) {
    suspend fun execute(postId: String): Post {
        return repository.getPost(postId)
    }
}

