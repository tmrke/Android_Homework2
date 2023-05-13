package ru.ageev.android_homework2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val images: Array<Image>?,
    val id: String,
    val text: String?,
    val likes: Like,
    //val owner: Profile,
    // val dataCreated: String,


)

