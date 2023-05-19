package ru.ageev.android_homework2.ui.post_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.databinding.ItemImageBinding


val diffUtilCallback = object : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.sizes[0].url == newItem.sizes[0].url
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}

class ImageAdapter : ListAdapter<Image, ImageViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding: ItemImageBinding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}