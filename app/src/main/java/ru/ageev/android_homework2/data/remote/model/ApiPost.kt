package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ageev.android_homework2.data.model.Like
import ru.ageev.android_homework2.data.model.ProfileCompact

@Serializable
data class ApiPost(
    //@SerialName("images") val images: List<ApiImage>? = null,
    @SerialName("id") val id: String,
    @SerialName("text") val text: String? = null,
    @SerialName("likes") val likes: Like,
    @SerialName("owner") val owner: ApiProfileCompact,
    @SerialName("dateCreated") val dateCreated: Long,
)

