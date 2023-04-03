package ru.ageev.android_homework2.images

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.databinding.ViewImagesCardBinding

class ImagesViewHolder(
    private val binding: ViewImagesCardBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        val textViewImages: TextView = binding.textViewImages
        val buttonImages: Button = binding.buttonImages
        val image1: ImageView = binding.image1
        val image2: ImageView = binding.image2
        val image3: ImageView = binding.image3
        val image4: ImageView = binding.image4
    }

}