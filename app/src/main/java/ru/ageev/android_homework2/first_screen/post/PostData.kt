package ru.ageev.android_homework2.first_screen.post

import android.os.Parcelable
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class PostData(
    val id: String = UUID.randomUUID().toString(),
    val profileImageUrl: String = "https://www.pinclipart.com/picdir/big/332-3324748_confused-person-png-clipart.png",
    val profileName: String = "Evolist",
    val date: String = "Apr 1, 2022 20:00:04",
    val text: String = LoremIpsum(300).values.joinToString(),
    val postImageUrl: String = "https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg",
    val likesCount: Int = 2
) : Parcelable
