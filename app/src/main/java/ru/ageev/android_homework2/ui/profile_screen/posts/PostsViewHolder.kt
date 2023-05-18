package ru.ageev.android_homework2.ui.profile_screen.posts

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.databinding.ViewPostCardBinding

class PostsViewHolder(
    private val binding: ViewPostCardBinding,
    private val onPostClick: (String) -> Unit,
    private val onProfileClick: (String) -> Unit,

    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        with(binding) {
            textViewPost.text = post.text
            textViewProfileName.text = post.owner.username
            imageViewPostProfileImage.load(post.owner.avatarUrl ?: R.drawable.profile)
            textViewDate.text = post.dateCreated

            val url = post.images?.getOrNull(0)?.sizes?.get(0)?.url

            imageViewMedia.load(url)

            textViewPost.setOnClickListener {
                onPostClick(post.id)
            }

            imageViewMedia.setOnClickListener {
                onPostClick(post.id)
            }

            imageViewPostProfileImage.setOnClickListener {
                onProfileClick(textViewProfileName.text.toString())
            }


            textViewProfileName.setOnClickListener {
                onProfileClick(textViewProfileName.text.toString())
            }

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