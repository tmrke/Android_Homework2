package ru.ageev.android_homework2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Like(
    var liked: Boolean,
    var likesCount: Int
)