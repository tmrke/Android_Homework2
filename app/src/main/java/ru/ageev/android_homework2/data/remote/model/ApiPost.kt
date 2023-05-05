package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.Serializable
import ru.ageev.android_homework2.data.model.Like

@Serializable
data class ApiPost(
    val id: String,
    //val dataCreated: Int,
    val text: String? = null,
    var likes: Like,
)