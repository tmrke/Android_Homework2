package ru.ageev.android_homework2.first_screen.collage

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R

import ru.ageev.android_homework2.databinding.ViewCollageCardBinding

class CollageViewHolder(
    private val binding: ViewCollageCardBinding, val onClick: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CollageData) {
        binding.image1.load(R.string.url_image1)
        binding.image2.load(R.string.url_image1)
        binding.image3.load(R.string.url_image1)
        binding.image4.load(R.string.url_image1)

        binding.buttonImages.setOnClickListener {
            onClick()
        }
    }
}