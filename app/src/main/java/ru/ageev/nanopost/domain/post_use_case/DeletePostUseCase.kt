package ru.ageev.nanopost.domain.post_use_case

import ru.ageev.nanopost.domain.repository.PostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend fun execute(postId: String) {
        repository.deletePost(postId)
    }
}