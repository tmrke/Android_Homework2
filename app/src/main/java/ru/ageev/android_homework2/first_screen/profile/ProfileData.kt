package ru.ageev.android_homework2.first_screen.profile

import java.util.*

data class ProfileData(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "Евлампия",
    val status: String = "не важно, что говорят крысы , за спиной у кисы"
)
