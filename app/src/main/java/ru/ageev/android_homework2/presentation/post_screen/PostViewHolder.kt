package ru.ageev.android_homework2.presentation.post_screen

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.FragmentPostBinding
import ru.ageev.android_homework2.databinding.ViewPostCardBinding

class PostViewHolder(
    private val binding: FragmentPostBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Post) {
        with(binding) {
            textViewPostText.text = item.text

//            imageViewMedia1.load(item.images?.get(0)?.images?.get(2)?.url)
//            imageViewMedia2.load(item.images?.get(1)?.images?.get(2)?.url)
//            imageViewMedia3.load(item.images?.get(2)?.images?.get(2)?.url)
//            imageViewMedia4.load(item.images?.get(3)?.images?.get(2)?.url)

            imageButtonFavorite.setIconResource(
                if (item.likes.liked) {
                    R.drawable.heart
                } else {
                    R.drawable.favorite
                }
            )

            imageButtonFavorite.text = item.likes.likesCount.toString()
        }
    }
}