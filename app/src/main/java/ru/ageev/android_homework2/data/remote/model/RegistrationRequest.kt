package ru.ageev.android_homework2.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    val username: String,
    val password: String
)