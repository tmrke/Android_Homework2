package ru.ageev.android_homework2.domain.post_use_case

import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.repository.PostRepository
import javax.inject.Inject


class CreatePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun execute(
        text: String?,
        byteArrays: List<ByteArray>?
    ): Post {
        return postRepository.createPost(text, byteArrays)
    }
}