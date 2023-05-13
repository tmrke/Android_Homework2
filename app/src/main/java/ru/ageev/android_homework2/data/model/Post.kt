package ru.ageev.android_homework2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    //var images: List<Image>?,
    var id: String,
    var text: String?,
    var likes: Like,
    //var owner: ProfileCompact,
    //var dataCreated: String,

)

