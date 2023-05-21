package ru.ageev.nanopost.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CheckUsernameEnumResponse {
    @SerialName("TooShort") TooShort,
    @SerialName("TooLong") TooLong,
    @SerialName("InvalidCharacters") InvalidCharacters,
    @SerialName("Taken") Taken,
    @SerialName("Free") Free
}