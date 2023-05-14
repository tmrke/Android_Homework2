package ru.ageev.android_homework2.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("id") var id: String,
    @SerialName("sizes") var sizes: List<ImageSize>,
    @SerialName("owner") var owner: ProfileCompact,
    @SerialName("dateCreated") var dateCreated: String
)