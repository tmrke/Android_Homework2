package ru.ageev.android_homework2.presentation.post_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.ageev.android_homework2.data.model.ImageSize
import ru.ageev.android_homework2.databinding.ItemImageBinding


val diffUtilCallback = object : DiffUtil.ItemCallback<ImageSize>() {
    override fun areItemsTheSame(oldItem: ImageSize, newItem: ImageSize): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: ImageSize, newItem: ImageSize): Boolean {
        return oldItem == newItem
    }
}

class ImageAdapter : ListAdapter<ImageSize, ImageViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding: ItemImageBinding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}