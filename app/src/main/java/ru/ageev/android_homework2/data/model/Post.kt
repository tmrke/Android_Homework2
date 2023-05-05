package ru.ageev.android_homework2.data.model

import android.media.Image
import java.util.Objects

data class Post(
    val id: String,
   // val dataCreated: String,
    val text: String?,
    val likes:Like
    // val images: Array<Image>,
    //val owner: Profile,

)

