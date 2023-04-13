package ru.ageev.android_homework2.images_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.ageev.android_homework2.databinding.ActivityImagesBinding


val diffUtilCallback = object : DiffUtil.ItemCallback<ImagesDataScreen>() {
    override fun areItemsTheSame(oldItem: ImagesDataScreen, newItem: ImagesDataScreen): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ImagesDataScreen, newItem: ImagesDataScreen): Boolean {
        return oldItem == newItem
    }
}

class ImagesAdapter :
    ListAdapter<ImagesDataScreen, ImagesViewHolderScreen>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolderScreen {
        val imageView = ImageView(parent.context)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP

        return ImagesViewHolderScreen(imageView)
    }

    override fun onBindViewHolder(holder: ImagesViewHolderScreen, position: Int) {
        holder.bind(getItem(position))
    }
}