package ru.ageev.nanopost.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ageev.nanopost.data.model.ProfileCompact

@Serializable
data class ApiImage(
    @SerialName("id") val id: String,
    @SerialName("sizes") val sizes: List<ApiImageSizes>,
    @SerialName("owner") val owner: ProfileCompact,
    @SerialName("dateCreated") val dateCreated: Long
)