package ru.ageev.android_homework2.data.remote.repository

import ru.ageev.android_homework2.data.model.Post


interface PostRepository {
    suspend fun getPost(postId: String): Post
}