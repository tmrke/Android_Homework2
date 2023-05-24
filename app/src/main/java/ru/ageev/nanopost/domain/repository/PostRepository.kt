package ru.ageev.nanopost.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ageev.nanopost.data.model.Post


interface PostRepository {
    suspend fun getPost(postId: String): Post
    suspend fun createPost(text: String?, list: List<ByteArray>?): Post
    suspend fun deletePost(postId: String)
    suspend fun getFeed(): Flow<PagingData<Post>>
}