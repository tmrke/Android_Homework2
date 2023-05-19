package ru.ageev.android_homework2.ui.creator_post_screen

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load

import ru.ageev.android_homework2.databinding.ItemImageBinding
import ru.ageev.android_homework2.databinding.ItemImageForCreatorBinding
import java.text.FieldPosition

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
