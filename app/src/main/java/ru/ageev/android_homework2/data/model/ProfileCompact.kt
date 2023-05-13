package ru.ageev.android_homework2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileCompact(
    val id: String,
    val username: String,
    val displayName: String?,
    val avatarUrl: String?,
    val subscribed: Boolean,
)