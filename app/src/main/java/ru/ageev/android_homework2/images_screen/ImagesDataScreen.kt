package ru.ageev.android_homework2.images_screen

import java.net.URI
import java.util.UUID

data class ImagesDataScreen(
    val id: String = UUID.randomUUID().toString(),
    val uri: String = "https://ru.pinterest.com/pin/296885800450883689"
)
