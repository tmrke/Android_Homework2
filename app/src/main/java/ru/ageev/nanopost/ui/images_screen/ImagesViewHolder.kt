package ru.ageev.nanopost.ui.images_screen


import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.nanopost.data.model.Image

import ru.ageev.nanopost.databinding.ItemImageBinding

class ImagesViewHolder(
    private val binding: ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Image, onImageClick: (String) -> Unit) {
        binding.imageViewPost.load(item.sizes[1].url)

        binding.imageViewPost.setOnClickListener {
            onImageClick(item.id)
        }
    }
}
