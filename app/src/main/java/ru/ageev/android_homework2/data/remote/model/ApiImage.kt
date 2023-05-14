package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ageev.android_homework2.data.model.ProfileCompact
import ru.ageev.android_homework2.data.remote.model.response.ApiImageSizes

@Serializable
data class ApiImage(
    @SerialName("id") var id: String,
    @SerialName("sizes") var sizes: List<ApiImageSizes>,
    @SerialName("owner") var owner: ProfileCompact,
    @SerialName("dateCreated") var dateCreated: String
)