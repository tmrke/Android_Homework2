package ru.ageev.android_homework2.first_screen.collage

import android.widget.Button
import java.util.*

data class CollageData(
    val id: String = UUID.randomUUID().toString(),
    val imageUrl1: String = "https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg",
    val imageUrl2: String = "https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg",
    val imageUrl3: String = "https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg",
    val imageUrl4: String = "https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg"
    )
