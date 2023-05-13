package ru.ageev.android_homework2.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Like(
    @SerialName("liked") var liked: Boolean,
    @SerialName("likesCount") var likesCount: Int
)