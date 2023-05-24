package ru.ageev.nanopost.domain.post_use_case

import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.data.repository.PostRepository
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