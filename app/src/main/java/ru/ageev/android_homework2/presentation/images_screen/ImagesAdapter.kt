package ru.ageev.android_homework2.presentation.images_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.data.ImageData
import ru.ageev.android_homework2.databinding.ItemImageBinding

class ImagesAdapter(private val images: List<ImageData>) :
    RecyclerView.Adapter<ImagesViewHolderScreen>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolderScreen {
        val binding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImagesViewHolderScreen(binding)
    }

    override fun onBindViewHolder(holder: ImagesViewHolderScreen, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}