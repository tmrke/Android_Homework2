package ru.ageev.android_homework2.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("id") val id: String,
    @SerialName("sizes") val sizes: List<ImageSize>,
    @SerialName("owner") val owner: ProfileCompact,
    @SerialName("dateCreated") val dateCreated: String
)

