package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.data.model.Like

@Serializable
data class ApiPost(
    @SerialName("id")val id: String,
    //@SerialName("dataCreated")val dataCreated: Int,
    @SerialName("text")val text: String? = null,
    //@SerialName("images")val images: Array<Image>? = emptyArray(),
    @SerialName("likes")var likes: Like,
)