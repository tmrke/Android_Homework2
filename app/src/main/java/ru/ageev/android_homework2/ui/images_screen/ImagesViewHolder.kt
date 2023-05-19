package ru.ageev.android_homework2.ui.images_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.data.model.Image

import ru.ageev.android_homework2.databinding.ItemImageBinding

class ImagesViewHolder(
    private val binding: ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Image, onImageClick: (String) -> Unit) {
        binding.imageViewPost.load(item.sizes[1].url)
        binding.imageButtonDelete.visibility = View.GONE

        binding.imageViewPost.setOnClickListener {
            onImageClick(item.id)
        }
    }
}
