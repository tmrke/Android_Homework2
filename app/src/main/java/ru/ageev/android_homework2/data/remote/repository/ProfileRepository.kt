package ru.ageev.android_homework2.data.remote.repository

import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile


interface ProfileRepository {
    suspend fun getProfile(profilerId: String): Profile

    suspend fun getPosts(profilerId: String): List<Post>
}