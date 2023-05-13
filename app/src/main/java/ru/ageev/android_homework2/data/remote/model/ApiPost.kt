package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.data.model.Like

@Serializable
data class ApiPost(
    @SerialName("images") val images: Array<Image>? = null,
    @SerialName("id") val id: String,
    @SerialName("text") val text: String? = null,
    @SerialName("likes") var likes: Like,
    //@SerialName("dataCreated")val dataCreated: Int,
)