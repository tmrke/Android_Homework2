package ru.ageev.android_homework2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val images:Array<ImageSize>,
    val id: String,
    //val owner: Profile,
    //dateCreated:String
)