package ru.ageev.android_homework2.images_screen

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R

import ru.ageev.android_homework2.databinding.ItemImageBinding

class ImagesViewHolderScreen(
    private val binding: ItemImageBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageData) {
        val uri: String = "https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg"
        binding.image.load(item.imageUri)
    }
}
