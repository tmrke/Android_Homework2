package ru.ageev.nanopost.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CheckUsernameResponse(
    val result: CheckUsernameEnumResponse,
)