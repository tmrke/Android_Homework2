package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName

data class EditProfileRequest(
    @SerialName("profileId") val profileId: String,
    @SerialName("displayName") val displayName: String?,
    @SerialName("bio") val bio: String?,
    @SerialName("avatar") val avatar: ByteArray?,
)