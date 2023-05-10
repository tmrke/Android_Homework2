package ru.ageev.android_homework2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageSize(
    val url: String,
    val width: Int,
    val height: Int,
)