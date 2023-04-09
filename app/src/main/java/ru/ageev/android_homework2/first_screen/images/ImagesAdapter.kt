package ru.ageev.android_homework2.first_screen.images


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.ageev.android_homework2.databinding.ViewImagesCardBinding

val diffUtilCallback = object : DiffUtil.ItemCallback<ImagesData>() {
    override fun areItemsTheSame(oldItem: ImagesData, newItem: ImagesData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImagesData, newItem: ImagesData): Boolean {
        return oldItem == newItem
    }
}

class ImagesAdapter : ListAdapter<ImagesData, ImagesViewHolder>(diffUtilCallback) {
    var onClick: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val binding =
            ViewImagesCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImagesViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}