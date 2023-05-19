package ru.ageev.android_homework2.ui.post_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.databinding.ItemImageBinding


class ImageViewHolder(
    private val binding: ItemImageBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(image: Image) {
        binding.imageViewPost.load(image.sizes[1].url)
        binding.imageButtonDelete.visibility = View.GONE
    }
}

