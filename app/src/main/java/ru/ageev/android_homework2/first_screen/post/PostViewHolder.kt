package ru.ageev.android_homework2.first_screen.post

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.databinding.ViewPostCardBinding

class PostViewHolder(
    private val binding: ViewPostCardBinding,
    private val context: Context,
    private val onClick: () -> Unit

) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        binding.textViewPostText.text = context.getString(R.string.text_post)
        binding.imageViewMedia.load(context.getString(R.string.url_image1))

        binding.viewPostCard.setOnClickListener {
            onClick()
        }
    }


}