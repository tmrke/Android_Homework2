package ru.ageev.android_homework2.data.remote.repository

import ru.ageev.android_homework2.data.mappers.PostMapper
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.remote.NanopostApiService
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val apiService: NanopostApiService,
    private val postMapper: PostMapper
) :
    PostRepository {
    override suspend fun getPost(postId: String): Post {
        return postMapper.toPost(apiService.getPost(postId))
    }
}