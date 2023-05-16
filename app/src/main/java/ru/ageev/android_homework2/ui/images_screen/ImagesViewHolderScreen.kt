package ru.ageev.android_homework2.ui.images_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.data.ImageData

import ru.ageev.android_homework2.databinding.ItemImageBinding

class ImagesViewHolderScreen(
    private val binding: ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageData) {
        binding.imageViewPost.load(item.imageUrl)
        binding.imageButtonDelete.visibility = View.GONE
    }
}
