package ru.ageev.android_homework2.images_screen

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import coil.load

class ImagesViewHolderScreen(
    private val imageView: ImageView
) : RecyclerView.ViewHolder(imageView) {
    fun bind(item: ImagesDataScreen) {
        imageView.load(item.imageUri)
    }
}