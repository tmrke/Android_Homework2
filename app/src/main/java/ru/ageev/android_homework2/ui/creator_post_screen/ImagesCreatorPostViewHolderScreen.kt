package ru.ageev.android_homework2.ui.creator_post_screen

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load

import ru.ageev.android_homework2.databinding.ItemImageBinding

class ImagesCreatorPostViewHolderScreen(
    private val binding: ItemImageBinding,
    private val onCancelClick: () -> Boolean
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(uri: String) {
        binding.imageViewPost.load(uri)

        binding.imageButtonDelete.setOnClickListener {
            binding.imageViewPost.setImageIcon(null)
            binding.imageButtonDelete.setImageIcon(null)

            onCancelClick()
        }
    }
}
