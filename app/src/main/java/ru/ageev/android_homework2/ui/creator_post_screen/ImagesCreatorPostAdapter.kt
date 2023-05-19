package ru.ageev.android_homework2.ui.creator_post_screen

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.databinding.ItemImageBinding
import ru.ageev.android_homework2.databinding.ItemImageForCreatorBinding

class ImagesCreatorPostAdapter(private val imagesUri: List<Uri>) :
    RecyclerView.Adapter<ImagesCreatorPostViewHolder>() {
    var onCancelClick: (Int) -> Unit = {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImagesCreatorPostViewHolder {
        val binding =
            ItemImageForCreatorBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImagesCreatorPostViewHolder(binding, onCancelClick)
    }

    override fun onBindViewHolder(holder: ImagesCreatorPostViewHolder, position: Int) {
        holder.bind(imagesUri[position], position)
    }

    override fun getItemCount(): Int {
        return imagesUri.size
    }
}