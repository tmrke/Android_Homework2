package ru.ageev.android_homework2.images_screen

import ru.ageev.android_homework2.R
import java.net.URI
import java.util.UUID

data class ImagesDataScreen(
    val id: String = UUID.randomUUID().toString(),
    val imageUri: String = R.string.url_image1.toString()
)
