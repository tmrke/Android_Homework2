package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName

data class EditProfileRequest(
    @SerialName("profileId") val profileId: String,
    @SerialName("displayName") val displayName: String?,
    @SerialName("bio") val bio: String?,
    @SerialName("avatar") val avatar: ByteArray?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EditProfileRequest

        if (profileId != other.profileId) return false
        if (displayName != other.displayName) return false
        if (bio != other.bio) return false
        if (avatar != null) {
            if (other.avatar == null) return false
            if (!avatar.contentEquals(other.avatar)) return false
        } else if (other.avatar != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = profileId.hashCode()
        result = 31 * result + (displayName?.hashCode() ?: 0)
        result = 31 * result + (bio?.hashCode() ?: 0)
        result = 31 * result + (avatar?.contentHashCode() ?: 0)
        return result
    }
}