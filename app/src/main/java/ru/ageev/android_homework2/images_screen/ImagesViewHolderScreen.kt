package ru.ageev.android_homework2.images_screen

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import coil.load

import ru.ageev.android_homework2.databinding.ViewImagesCardScreenBinding

class ImagesViewHolderScreen (
    private val binding: ViewImagesCardScreenBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImagesDataScreen) {
        val imageView = ImageView(binding.root.context)
        binding.root.addView(imageView)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        imageView.load(item.imageUri)
    }
}