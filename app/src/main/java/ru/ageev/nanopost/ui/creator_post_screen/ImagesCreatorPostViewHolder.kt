package ru.ageev.nanopost.ui.creator_post_screen

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import coil.load

import ru.ageev.nanopost.databinding.ItemImageForCreatorBinding

class ImagesCreatorPostViewHolder(
    private val binding: ItemImageForCreatorBinding,
    private val onCancelClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(uri: Uri, position: Int) {
        binding.imageViewPost.load(uri)

        binding.imageButtonDelete.setOnClickListener {
            onCancelClick(position)
        }
    }
}
