package ru.ageev.android_homework2.first_screen.images

import android.widget.Button
import android.widget.ImageView
import java.util.*

data class ImagesData(
    val id: String = UUID.randomUUID().toString(),
    val textImages: String,
    val buttonImages: Button,
    val imageUrl1: String
)
