package ru.ageev.android_homework2.first_screen.post

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.databinding.ViewPostCardBinding

class PostViewHolder(
    private val binding: ViewPostCardBinding,
    private val context: Context,
    private val onClick: () -> Unit

) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PostData) {
        with(binding) {
            textViewPostText.text = item.text
            imageViewMedia.load(item.postImageUrl)
            imageViewPostProfileImage.load(item.profileImageUrl)

            viewPostCard.setOnClickListener {
                onClick()
            }
        }


    }


}