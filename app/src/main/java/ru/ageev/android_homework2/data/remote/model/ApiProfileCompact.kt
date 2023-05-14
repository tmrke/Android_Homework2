package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiProfileCompact(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String,
    @SerialName("displayName") val displayName: String? = "ololo",
    @SerialName("avatarUrl") val avatarUrl: String? = null,
    @SerialName("subscribed") val subscribed: Boolean,
)