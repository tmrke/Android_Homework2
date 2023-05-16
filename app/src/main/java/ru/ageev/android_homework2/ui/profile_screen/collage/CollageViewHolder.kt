package ru.ageev.android_homework2.ui.profile_screen.collage

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding

class CollageViewHolder(
    private val binding: ViewCollageCardBinding,
    val onClick: () -> Unit,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageData) {
        binding.image1.load(context.getString(R.string.url_image1))
        binding.image2.load(context.getString(R.string.url_image1))
        binding.image3.load(context.getString(R.string.url_image1))
        binding.image4.load(context.getString(R.string.url_image1))

        binding.root.setOnClickListener {
            onClick()
        }


    }
}