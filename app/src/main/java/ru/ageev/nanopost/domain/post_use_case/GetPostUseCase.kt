package ru.ageev.nanopost.domain.post_use_case

import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.data.remote.repository.PostRepositoryImpl
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val repository: PostRepositoryImpl,
) {
    suspend fun execute(postId: String): Post {
        return repository.getPost(postId)
    }
}

