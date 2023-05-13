package ru.ageev.android_homework2.domain.post_use_case

import ru.ageev.android_homework2.data.remote.repository.PostRepository
import ru.ageev.android_homework2.data.remote.repository.RegisterRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend fun execute(postId: String) {
        repository.deletePost(postId)
    }
}