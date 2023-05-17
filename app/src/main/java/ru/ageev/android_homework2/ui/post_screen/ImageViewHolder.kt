package ru.ageev.android_homework2.ui.post_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.data.model.ImageSize
import ru.ageev.android_homework2.databinding.ItemImageBinding


class ImageViewHolder(
    private val binding: ItemImageBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(image: ImageSize) {
        if (image == null) {
            binding.imageViewPost.visibility = View.GONE
        } else {
            binding.imageViewPost.load(image.url)
        }
    }
}

