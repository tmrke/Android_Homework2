package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiProfile(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String,
    @SerialName("displayName") val displayName: String? = null,
    @SerialName("bio") val bio: String? = null,
//  @SerialName("avatarId")  val avatarId: String?,
//  @SerialName("avatarSmall")  val avatarSmall: String?,
//  @SerialName("avatarLarge")  val avatarLarge: String?,
//  @SerialName("subscribed")  val subscribed: Boolean,
    @SerialName("subscribersCount") val subscribersCount: Int,
    @SerialName("postsCount") val postsCount: Int,
    @SerialName("imagesCount") val imagesCount: Int
)
