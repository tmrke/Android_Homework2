package ru.ageev.android_homework2.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    //@SerialName("images") var images: List<Image>?,
    @SerialName("id") var id: String,
    @SerialName("text") var text: String?,
    @SerialName("likes") var likes: Like,
    @SerialName("owner") var owner: ProfileCompact,
    @SerialName("dateCreated") var dateCreated: String,
)

