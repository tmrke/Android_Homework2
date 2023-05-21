package ru.ageev.nanopost.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Like(
    @SerialName("liked") var liked: Boolean,
    @SerialName("likesCount") val likesCount: Int
)