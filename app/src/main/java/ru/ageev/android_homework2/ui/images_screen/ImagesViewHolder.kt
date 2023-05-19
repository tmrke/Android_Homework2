package ru.ageev.android_homework2.ui.images_screen

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.data.model.Image

import ru.ageev.android_homework2.databinding.ItemImageBinding

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
