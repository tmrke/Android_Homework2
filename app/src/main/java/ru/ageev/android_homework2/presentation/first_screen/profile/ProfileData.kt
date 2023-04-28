package ru.ageev.android_homework2.presentation.first_screen.profile

import java.util.*

data class ProfileData(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "Евлампия",
    val status: String = "не важно, что говорят крысы , за спиной у кисы",
    val profileImageUrl: String = "https://www.pinclipart.com/picdir/big/332-3324748_confused-person-png-clipart.png"
)
