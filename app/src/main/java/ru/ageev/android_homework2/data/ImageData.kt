package ru.ageev.android_homework2.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class ImageData(
    val id: String = UUID.randomUUID().toString(),
    val imageUrl: String = "https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg"
) : Parcelable
