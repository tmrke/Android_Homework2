package ru.ageev.android_homework2.presentation.post_screen

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.data.model.ImageSize
import ru.ageev.android_homework2.databinding.ItemImageBinding


class ImageViewHolder(
    private val binding: ItemImageBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(image: ImageSize) {
        binding.imageViewPost.load(image.url)
    }
}

