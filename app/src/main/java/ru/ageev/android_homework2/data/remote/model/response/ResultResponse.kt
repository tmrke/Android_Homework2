package ru.ageev.android_homework2.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse(
    var result: Boolean
)