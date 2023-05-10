package ru.ageev.android_homework2.presentation.post_screen

import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.ViewPostCardBinding

class PostViewHolder(
    private val binding: ViewPostCardBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        with(binding) {
            textViewPostText.text = post.text

//            imageViewMedia1.load(post.images?.get(0)?.images?.get(2)?.url)
//            imageViewMedia2.load(post.images?.get(1)?.images?.get(2)?.url)
//            imageViewMedia3.load(post.images?.get(2)?.images?.get(2)?.url)
//            imageViewMedia4.load(post.images?.get(3)?.images?.get(2)?.url)

            imageButtonFavorite.setIconResource(
                if (post.likes.liked) {
                    R.drawable.heart
                } else {
                    R.drawable.favorite
                }
            )

            imageButtonFavorite.text = post.likes.likesCount.toString()

            imageButtonFavorite.setOnClickListener {
                if (post.likes.liked) {
                    imageButtonFavorite.text = post.likes.likesCount.toString()
                    imageButtonFavorite.setIconResource(R.drawable.favorite)
                } else {
                    imageButtonFavorite.text = (post.likes.likesCount + 1).toString()
                    imageButtonFavorite.setIconResource(R.drawable.heart)
                }

                post.likes.liked = !post.likes.liked
            }
        }
    }
}