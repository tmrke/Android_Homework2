package ru.ageev.android_homework2.ui.profile_screen.collage

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.databinding.ViewCollageCardBinding

class CollageViewHolder(
    private val binding: ViewCollageCardBinding,
    val onClick: () -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(image0: String?, image1: String?, image2: String?, image3: String?) {
        binding.image1.load(image0)
        binding.image2.load(image1)
        binding.image3.load(image2)
        binding.image4.load(image3)

        binding.root.setOnClickListener {
            onClick()
        }




    }
}