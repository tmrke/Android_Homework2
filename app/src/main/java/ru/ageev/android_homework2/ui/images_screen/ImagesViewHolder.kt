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
    fun bind(item: Image) {
//        binding.imageViewPost.load(item.sizes[0].url)

        binding.imageViewPost.load("https://i.pinimg.com/564x/98/3a/64/983a6470c037bb11390faf4c868f9c5c.jpg")
        binding.imageButtonDelete.visibility = View.GONE
    }
}
