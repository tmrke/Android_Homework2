package ru.ageev.android_homework2.first_screen.post

import java.util.*

data class PostData(
    val id: String = UUID.randomUUID().toString(),
)
