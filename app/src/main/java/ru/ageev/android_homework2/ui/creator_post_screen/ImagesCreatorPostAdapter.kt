package ru.ageev.android_homework2.ui.creator_post_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.databinding.ItemImageBinding

class ImagesCreatorPostAdapter(private val imagesUri: List<String>) :
    RecyclerView.Adapter<ImagesCreatorPostViewHolderScreen>() {
    var onCancelClick: () -> Boolean = { true }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImagesCreatorPostViewHolderScreen {
        val binding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImagesCreatorPostViewHolderScreen(binding, onCancelClick)
    }

    override fun onBindViewHolder(holder: ImagesCreatorPostViewHolderScreen, position: Int) {
        holder.bind(imagesUri[position])
    }

    override fun getItemCount(): Int {
        return imagesUri.size
    }
}