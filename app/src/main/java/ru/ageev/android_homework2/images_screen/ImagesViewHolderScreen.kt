package ru.ageev.android_homework2.images_screen

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.ActivityImagesBinding

class ImagesViewHolderScreen(
    private val binding: ActivityImagesBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        val newImageView = ImageView(binding.root.context)
        newImageView.load(R.string.url_image1)

        binding.recyclerViewImages.addView(newImageView)
    }
}
