package ru.ageev.android_homework2.images_screen

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import coil.load

import ru.ageev.android_homework2.databinding.ViewImagesCardScreenBinding

class ImagesViewHolderScreen(
    private val binding: ViewImagesCardScreenBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private val imageView = ImageView(binding.root.context)
        fun bind(item: ImagesDataScreen) {
        binding.root.addView(imageView)
        imageView.load(item.uri)
    }
}