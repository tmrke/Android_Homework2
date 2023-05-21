package ru.ageev.nanopost.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    @SerialName("images") val images: List<Image>?,
    @SerialName("id") val id: String,
    @SerialName("text") val text: String?,
    @SerialName("likes") val likes: Like,
    @SerialName("owner") val owner: ProfileCompact,
    @SerialName("dateCreated") val dateCreated: String,
)

