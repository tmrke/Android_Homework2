package ru.ageev.android_homework2.images_screen

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R

import ru.ageev.android_homework2.databinding.ItemImageBinding

class ImagesViewHolderScreen(
    private val binding: ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageData) {
        binding.image.load(item.imageUri)
    }
}
