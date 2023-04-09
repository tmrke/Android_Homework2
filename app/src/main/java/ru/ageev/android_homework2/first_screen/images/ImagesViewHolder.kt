package ru.ageev.android_homework2.first_screen.images

import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.ImageLoader

import ru.ageev.android_homework2.databinding.ViewImagesCardBinding

class ImagesViewHolder(
    private val binding: ViewImagesCardBinding, val onClick: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImagesData) {
        binding.buttonImages.setOnClickListener {
            onClick()
        }
    }
}