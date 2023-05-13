package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.data.model.Like
import ru.ageev.android_homework2.data.model.ProfileCompact

@Serializable
data class ApiPost(
    //@SerialName("images") var images: List<Image>? = null,
    @SerialName("id") var id: String,
    @SerialName("text") var text: String? = null,
    @SerialName("likes") var likes: Like,
    //@SerialName("owner") var owner: ProfileCompact
    //@SerialName("dataCreated")var dataCreated: Long,
)