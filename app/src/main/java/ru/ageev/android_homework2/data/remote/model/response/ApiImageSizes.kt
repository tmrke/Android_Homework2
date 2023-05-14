package ru.ageev.android_homework2.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiImageSizes(
    @SerialName("url") var url: String,
    @SerialName("width") var width: Int,
    @SerialName("height") var height: Int,
)