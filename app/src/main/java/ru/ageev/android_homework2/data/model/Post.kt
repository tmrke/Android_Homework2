package ru.ageev.android_homework2.data.model

import android.media.Image
import java.util.Objects

data class Post(
    val id: String,
    val owner: Profile,
    val likesCount: Int,
    val dataCreated: Int,
    val text: String,
    val images: Array<Image>,
    val likes: Objects
)

