package ru.ageev.nanopost.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiProfileCompact(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String,
    @SerialName("displayName") val displayName: String? = null,
    @SerialName("avatarUrl") val avatarUrl: String? = null,
    @SerialName("subscribed") val subscribed: Boolean,
)

