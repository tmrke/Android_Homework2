package ru.ageev.android_homework2.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageSize(
    @SerialName("url") var url: String,
    @SerialName("width") var width: Int,
    @SerialName("height") var height: Int,
)